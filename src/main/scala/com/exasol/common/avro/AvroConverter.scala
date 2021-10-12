package com.exasol.common.avro

import java.nio.ByteBuffer
import java.sql.Date
import java.sql.Timestamp
import java.time._
import java.util.{Map => JMap}
import java.util.Collection

import com.exasol.common.json.JsonMapper
import com.exasol.errorreporting.ExaError

import org.apache.avro.Conversions.DecimalConversion
import org.apache.avro.LogicalTypes
import org.apache.avro.Schema
import org.apache.avro.data.TimeConversions.TimestampMicrosConversion
import org.apache.avro.data.TimeConversions.TimestampMillisConversion
import org.apache.avro.generic.GenericFixed
import org.apache.avro.generic.IndexedRecord
import org.apache.avro.util.Utf8

/**
 * Avro data type converter helper class.
 */
final class AvroConverter {

  private[this] val EXASOL_DECIMAL_PRECISION = 36
  private[this] lazy val decimalConverter = new DecimalConversion()
  private[this] lazy val timestampMillisConverter = new TimestampMillisConversion()
  private[this] lazy val timestampMicrosConverter = new TimestampMicrosConversion()

  /**
   * Converts Avro schema field value into a Java datatype.
   *
   * If Avro value is a complex datatype, then it is converted to the
   * JSON string.
   *
   * @param value Avro record field value
   * @param schema Avro record field schema
   * @return regular Java data type
   */
  def convert(value: Any, schema: Schema): Any = {
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

  private[this] def getIntValue(value: Any, field: Schema): Any =
    field.getLogicalType() match {
      case _: LogicalTypes.Date => dateFromSinceEpoch(value.asInstanceOf[Int].longValue())
      case _                    => value
    }

  private[this] def dateFromSinceEpoch(days: Long): Date = {
    // scalastyle:off magic.number
    val date = LocalDateTime.of(1970, 1, 1, 0, 0, 0).plusDays(days)
    // scalastyle:on
    val millis = date.atZone(ZoneId.systemDefault).toInstant().toEpochMilli()
    new Date(millis)
  }

  private[this] def getLongValue(value: Any, field: Schema): Any =
    field.getLogicalType() match {
      case lt: LogicalTypes.TimestampMillis =>
        Timestamp.from(timestampMillisConverter.fromLong(value.asInstanceOf[Long], field, lt))
      case lt: LogicalTypes.TimestampMicros =>
        Timestamp.from(timestampMicrosConverter.fromLong(value.asInstanceOf[Long], field, lt))
      case _ => value
    }

  private[this] def getFixedValue(value: Any, field: Schema): Any =
    field.getLogicalType() match {
      case lt: LogicalTypes.Decimal =>
        checkPrecision(lt)
        decimalConverter.fromFixed(value.asInstanceOf[GenericFixed], field, lt)
      case _ => getStringValue(value, field)
    }

  private[this] def getBytesValue(value: Any, field: Schema): Any =
    field.getLogicalType() match {
      case lt: LogicalTypes.Decimal =>
        checkPrecision(lt)
        decimalConverter.fromBytes(value.asInstanceOf[ByteBuffer], field, lt)
      case _ => getStringValue(value, field)
    }

  private[this] def checkPrecision(logicalType: LogicalTypes.Decimal): Unit = {
    val precision = logicalType.getPrecision()
    if (precision > EXASOL_DECIMAL_PRECISION) {
      throw new IllegalArgumentException(
        ExaError
          .messageBuilder("E-IEUCS-5")
          .message("Decimal precision {{PRECISION}} is larger than maximal allowed {{ALLOWED}} precision.")
          .parameter("PRECISION", precision.toString())
          .parameter("ALLOWED", EXASOL_DECIMAL_PRECISION.toString())
          .mitigation("Please ensure that Avro decimal value precision fits into Exasol decimal precision.")
          .toString()
      )
    }
  }

  private[this] def getStringValue(value: Any, field: Schema): String =
    value match {
      case str: String            => str
      case utf: Utf8              => utf.toString
      case byteBuffer: ByteBuffer => new String(byteBuffer.array, "UTF8")
      case arrayByte: Array[Byte] => new String(arrayByte, "UTF8")
      case fixed: GenericFixed    => new String(fixed.bytes(), "UTF8")
      case _ =>
        throw new IllegalArgumentException(
          ExaError
            .messageBuilder("E-IEUCS-6")
            .message("Avro field {{FIELD}} type cannot be converted to string.", field.getName())
            .mitigation("Please ensure that Exasol table column and Avro field types match.")
            .toString()
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
          throw new IllegalArgumentException(getAvroUnionErrorMessage())
        }
      case _ => throw new IllegalArgumentException(getAvroUnionErrorMessage())
    }
  }

  private[this] def getAvroUnionErrorMessage(): String =
    ExaError
      .messageBuilder("E-IEUCS-7")
      .message("Avro union type does not contain a primitive type and null.")
      .mitigation("Please make sure that Avro union type contains a primitive type and a null.")
      .toString()

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
        ExaError
          .messageBuilder("E-IEUCS-8")
          .message("Unsupported Avro array type {{TYPE}}.", other.getClass.getName())
          .mitigation("Please make sure Avro array type is of Array or Collection types.")
          .ticketMitigation()
          .toString()
      )
  }

  // Avro Map key is either Utf8 or Java String type, both can be
  // converted to string.
  @SuppressWarnings(Array("org.wartremover.warts.ToString"))
  private[this] def getMapValue(map: Any, field: Schema): JMap[String, Any] = {
    val result = new java.util.HashMap[String, Any]()
    map.asInstanceOf[JMap[_ <: java.lang.CharSequence, _]].forEach { (key, value) =>
      val _ = result.put(key.toString(), getAvroValue(value, field.getValueType()))
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
        ExaError
          .messageBuilder("E-IEUCS-9")
          .message("Unsupported Avro record type {{TYPE}}.", other.getClass.getName())
          .mitigation("Please make sure that Avro record type is of IndexedRecord type.")
          .ticketMitigation()
          .toString()
      )
  }

}
