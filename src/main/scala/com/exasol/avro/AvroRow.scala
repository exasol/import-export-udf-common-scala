package com.exasol.common.avro

import java.nio.ByteBuffer
import java.util.{Map => JMap}
import java.util.Collection

import com.exasol.common.data.Row
import com.exasol.common.json.JsonMapper

import org.apache.avro.Schema
import org.apache.avro.generic.GenericFixed
import org.apache.avro.generic.GenericRecord
import org.apache.avro.generic.IndexedRecord
import org.apache.avro.util.Utf8

/**
 * A factory method that creates [[com.exasol.common.data.Row]]
 * instances from Avro [[org.apache.avro.generic.GenericRecord]] value.
 */
object AvroRow {

  /**
   * Converts Avro record into an internal Row.
   *
   * @param avroRecord a generic Avro record
   * @return a Row representation of the given Avro record
   */
  def apply(avroRecord: GenericRecord): Row = {
    val size = avroRecord.getSchema.getFields.size
    val values = Array.ofDim[Any](size)
    val fields = avroRecord.getSchema().getFields()
    for { index <- 0 until fields.size } {
      val fieldSchema = fields.get(index).schema()
      val fieldValue = getAvroValue(avroRecord.get(index), fieldSchema)
      if (isPrimitiveAvroType(fieldSchema.getType())) {
        values.update(index, fieldValue)
      } else {
        values.update(index, JsonMapper.toJson(fieldValue))
      }
    }
    Row(values.toSeq)
  }

  private[this] def isPrimitiveAvroType(avroType: Schema.Type): Boolean =
    avroType match {
      case Schema.Type.ARRAY  => false
      case Schema.Type.MAP    => false
      case Schema.Type.RECORD => false
      case _                  => true
    }

  @SuppressWarnings(Array("org.wartremover.warts.Return", "org.wartremover.warts.ToString"))
  private[this] def getAvroValue(value: Any, field: Schema): Any = {
    if (value == null) {
      return null // scalastyle:ignore return
    }
    field.getType() match {
      case Schema.Type.NULL    => value
      case Schema.Type.BOOLEAN => value
      case Schema.Type.INT     => value
      case Schema.Type.LONG    => value
      case Schema.Type.FLOAT   => value
      case Schema.Type.DOUBLE  => value
      case Schema.Type.STRING  => getStringValue(value, field)
      case Schema.Type.FIXED   => getStringValue(value, field)
      case Schema.Type.BYTES   => getStringValue(value, field)
      case Schema.Type.ENUM    => value.toString
      case Schema.Type.UNION   => getUnionValue(value, field)
      case Schema.Type.ARRAY   => getArrayValue(value, field)
      case Schema.Type.MAP     => getMapValue(value, field)
      case Schema.Type.RECORD  => getRecordValue(value)
      case field =>
        throw new IllegalArgumentException(s"Avro ${field.getName} type is not supported!")
    }
  }

  private[this] def getStringValue(value: Any, field: Schema): String =
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

  private[this] def getUnionValue(value: Any, field: Schema): Any = {
    val types = field.getTypes()
    val typesSize = types.size()
    typesSize match {
      case 1 => getAvroValue(value, types.get(0))
      case 2 =>
        if (types.get(0).getType() == Schema.Type.NULL) {
          getAvroValue(value, types.get(1))
        } else if (types.get(1).getType() == Schema.Type.NULL) {
          getAvroValue(value, types.get(0))
        } else {
          throw new IllegalArgumentException(
            "Avro Union type should contain a primitive and null!"
          )
        }
      case _ =>
        throw new IllegalArgumentException("Avro Union type should contain a primitive and null!")
    }
  }

  private[this] def getArrayValue(value: Any, field: Schema): Array[Any] = value match {
    case array: Array[_] => array.map(getAvroValue(_, field.getElementType()))
    case list: Collection[_] =>
      val result = new Array[Any](list.size)
      var i = 0
      list.stream().forEach { element =>
        val _ = result.update(i, getAvroValue(element, field.getElementType()))
        i += 1
      }
      result
    case other =>
      throw new IllegalArgumentException(
        s"Unsupported Avro Array type '${other.getClass.getName()}'."
      )
  }

  private[this] def getMapValue(map: Any, field: Schema): JMap[String, Any] = {
    val result = new java.util.HashMap[String, Any]()
    map.asInstanceOf[JMap[String, _]].forEach { (key, value) =>
      val _ = result.put(key, getAvroValue(value, field.getValueType()))
    }
    result
  }

  private[this] def getRecordValue(value: Any): JMap[String, Any] = value match {
    case record: IndexedRecord =>
      val size = record.getSchema().getFields().size
      val fields = record.getSchema().getFields()
      val result = new java.util.HashMap[String, Any]()
      var i = 0
      while (i < size) {
        val _ =
          result.put(fields.get(i).name, getAvroValue(record.get(i), fields.get(i).schema))
        i += 1
      }
      result
    case other =>
      throw new IllegalArgumentException(
        s"Unsupported Avro Record type '${other.getClass.getName()}'."
      )
  }

}
