package com.exasol.common.avro

import java.nio.ByteBuffer

import com.exasol.common.data.Row

import org.apache.avro.Schema
import org.apache.avro.generic.GenericFixed
import org.apache.avro.generic.GenericRecord
import org.apache.avro.util.Utf8

/**
 * A factory method that creates [[com.exasol.common.data.Row]]
 * instances from Avro [[org.apache.avro.generic.GenericRecord]] value.
 */
object AvroRow {

  def apply(avroRecord: GenericRecord): Row = {
    val size = avroRecord.getSchema.getFields.size
    val values = Array.ofDim[Any](size)
    val fields = avroRecord.getSchema().getFields()
    for { index <- 0 until fields.size } {
      values.update(index, getAvroRecordValue(avroRecord.get(index), fields.get(index).schema))
    }
    Row(values.toSeq)
  }

  @SuppressWarnings(Array("org.wartremover.warts.Return", "org.wartremover.warts.ToString"))
  private[this] def getAvroRecordValue(value: Any, field: Schema): Any = {
    if (value == null) {
      return null // scalastyle:ignore return

    }
    field.getType match {
      case Schema.Type.NULL    => value
      case Schema.Type.BOOLEAN => value
      case Schema.Type.INT     => value
      case Schema.Type.LONG    => value
      case Schema.Type.FLOAT   => value
      case Schema.Type.DOUBLE  => value
      case Schema.Type.STRING  => getAvroValueAsString(value, field)
      case Schema.Type.FIXED   => getAvroValueAsString(value, field)
      case Schema.Type.BYTES   => getAvroValueAsString(value, field)
      case Schema.Type.ENUM    => value.toString
      case Schema.Type.UNION   => getAvroUnionValue(value, field)
      case field =>
        throw new IllegalArgumentException(s"Avro ${field.getName} type is not supported!")
    }
  }

  private[this] def getAvroValueAsString(value: Any, field: Schema): String =
    value match {
      case str: String            => str
      case utf: Utf8              => utf.toString
      case byteBuffer: ByteBuffer => new String(byteBuffer.array)
      case arrayByte: Array[Byte] => new String(arrayByte)
      case fixed: GenericFixed    => new String(fixed.bytes())
      case _ =>
        throw new IllegalArgumentException(
          s"Avro ${field.getName} type cannot be converted to string!"
        )
    }

  private[this] def getAvroUnionValue(value: Any, field: Schema): Any = {
    val types = field.getTypes()
    val typesSize = types.size()
    typesSize match {
      case 1 => getAvroRecordValue(value, types.get(0))
      case 2 =>
        if (types.get(0).getType() == Schema.Type.NULL) {
          getAvroRecordValue(value, types.get(1))
        } else if (types.get(1).getType() == Schema.Type.NULL) {
          getAvroRecordValue(value, types.get(0))
        } else {
          throw new IllegalArgumentException(
            "Avro Union type should contain a primitive and null!"
          )
        }
      case _ =>
        throw new IllegalArgumentException("Avro Union type should contain a primitive and null!")
    }
  }

}
