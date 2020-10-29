package com.exasol.common.avro

import java.nio.ByteBuffer
import java.sql.Date
import java.sql.Timestamp
import java.time._
import java.util.{Map => JMap}
import java.util.Collection

import com.exasol.common.data.Row
import com.exasol.common.json.JsonMapper

import org.apache.avro.Conversions
import org.apache.avro.LogicalTypes
import org.apache.avro.Schema
import org.apache.avro.data.TimeConversions
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
   * Converts an Avro record into an internal [[com.exasol.common.data.Row]].
   *
   * @param avroRecord a generic Avro record
   * @return a Row representation of the given Avro record
   */
  def apply(avroRecord: GenericRecord): Row = {
    val fields = avroRecord.getSchema().getFields()
    val size = fields.size()
    val values = Array.ofDim[Any](size)
    for { i <- 0 until size } {
      values.update(i, getAvroFieldValue(fields.get(i).schema(), avroRecord.get(i)))
    }
    Row(values.toSeq)
  }

  private[this] def getAvroFieldValue(schema: Schema, value: Any): Any = {
    val fieldValue = getAvroValue(value, schema)
    if (isPrimitiveAvroType(schema.getType())) {
      fieldValue
    } else {
      JsonMapper.toJson(fieldValue)
    }
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
      case Schema.Type.INT     => getIntValue(value, field)
      case Schema.Type.LONG    => getLongValue(value, field)
      case Schema.Type.FLOAT   => value
      case Schema.Type.DOUBLE  => value
      case Schema.Type.STRING  => getStringValue(value, field)
      case Schema.Type.FIXED   => getFixedValue(value, field)
      case Schema.Type.BYTES   => getBytesValue(value, field)
      case Schema.Type.ENUM    => value.toString
      case Schema.Type.UNION   => getUnionValue(value, field)
      case Schema.Type.ARRAY   => getArrayValue(value, field)
      case Schema.Type.MAP     => getMapValue(value, field)
      case Schema.Type.RECORD  => getRecordValue(value)
    }
  }

  private[this] def getIntValue(value: Any, field: Schema): Any = {
    val logicalType = field.getLogicalType()
    logicalType match {
      case _: LogicalTypes.Date => dateFromSinceEpoch(value.asInstanceOf[Int].longValue())
      case _                    => value
    }
  }

  private[this] def dateFromSinceEpoch(days: Long): Date = {
    // scalastyle:off magic.number
    val date = LocalDateTime.of(1970, 1, 1, 0, 0, 0).plusDays(days)
    // scalastyle:on
    val millis = date.atZone(ZoneId.systemDefault).toInstant().toEpochMilli()
    new Date(millis)
  }

  private[this] def getLongValue(value: Any, field: Schema): Any = {
    val logicalType = field.getLogicalType()
    logicalType match {
      case lt: LogicalTypes.TimestampMillis =>
        Timestamp.from(
          new TimeConversions.TimestampMillisConversion()
            .fromLong(value.asInstanceOf[Long], field, lt)
        )
      case lt: LogicalTypes.TimestampMicros =>
        Timestamp.from(
          new TimeConversions.TimestampMicrosConversion()
            .fromLong(value.asInstanceOf[Long], field, lt)
        )
      case _ => value
    }
  }

  private[this] def getFixedValue(value: Any, field: Schema): Any = {
    val logicalType = field.getLogicalType()
    logicalType match {
      case lt: LogicalTypes.Decimal =>
        new Conversions.DecimalConversion()
          .fromFixed(value.asInstanceOf[GenericFixed], field, lt)
      case _ => getStringValue(value, field)
    }
  }

  private[this] def getBytesValue(value: Any, field: Schema): Any = {
    val logicalType = field.getLogicalType()
    logicalType match {
      case lt: LogicalTypes.Decimal =>
        new Conversions.DecimalConversion()
          .fromBytes(value.asInstanceOf[ByteBuffer], field, lt)
      case _ => getStringValue(value, field)
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
