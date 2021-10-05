package com.exasol.common.avro

import java.math.BigDecimal
import java.nio.ByteBuffer
import java.sql.Date
import java.sql.Timestamp

import com.exasol.common.data.Row

import org.apache.avro.Conversions
import org.apache.avro.LogicalTypes
import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.scalatest.funsuite.AnyFunSuite

class AvroLogicalTypesTest extends AnyFunSuite {

  private[this] def getLogicalSchema(avroType: String): Schema =
    new Schema.Parser()
      .parse(
        s"""|{
            |  "type": "record",
            |  "namespace": "com.exasol.avro.Types",
            |  "name": "LogicalTypesRecord",
            |  "fields": [{
            |    "name": "value",
            |    "type": $avroType
            |  }]
            |}
            |""".stripMargin
      )

  test("parse avro int with date logical type as Java SQL date type") {
    val daysSinceEpoch = Seq(-719164, -70672, -21060, -365, -1, 0, 7252, 17317, 17937)
    val expectedDates = Seq(
      "0001-01-01",
      "1776-07-04",
      "1912-05-05",
      "1969-01-01",
      "1969-12-31",
      "1970-01-01",
      "1989-11-09",
      "2017-05-31",
      "2019-02-10"
    )
    val schema = getLogicalSchema("""{"type":"int","logicalType":"date"}""")
    daysSinceEpoch.zipWithIndex.foreach { case (days, i) =>
      val record = new GenericData.Record(schema)
      record.put("value", days)
      assert(AvroRow(record).getAs[Date](0).toString() === expectedDates(i))
    }
  }

  private[this] val milliseconds = Seq(-15854399877000L, 1603927542000L, 0L)

  test("parse avro long with timestamp-millis as Java SQL timestamp type") {
    val schema = getLogicalSchema("""{"type":"long","logicalType":"timestamp-millis"}""")
    milliseconds.foreach { case millis =>
      val record = new GenericData.Record(schema)
      record.put("value", millis)
      assert(AvroRow(record).getAs[Timestamp](0) === new Timestamp(millis))
    }
  }

  test("parse avro long with timestamp-micros as Java SQL timestamp type") {
    val schema = getLogicalSchema("""{"type":"long","logicalType":"timestamp-micros"}""")
    milliseconds.foreach { case millis =>
      val record = new GenericData.Record(schema)
      record.put("value", millis * 1000L + 13)
      val expected = new Timestamp(millis)
      expected.setNanos(13000)
      assert(AvroRow(record).getAs[Timestamp](0) === expected)
    }
  }

  private[this] val precision = 4
  private[this] val scale = 2
  private[this] val decimals = Map(
    "3.14" -> "3.14",
    "2.01" -> "2.01",
    "1.2" -> "1.20",
    "0.5" -> "0.50",
    "-1" -> "-1.00",
    "-2.31" -> "-2.31"
  )

  test("parse avro bytes with decimal as Java BigDecimal type") {
    val schema = getLogicalSchema(
      s"""|{
          |   "type":"bytes",
          |   "logicalType":"decimal",
          |   "precision":4,
          |   "scale":2
          |}""".stripMargin
    )
    decimals.foreach { case (given, expected) =>
      val record = new GenericData.Record(schema)
      val bytes = ByteBuffer.wrap(
        new BigDecimal(given).setScale(scale).unscaledValue().toByteArray()
      )
      record.put("value", bytes)
      assert(AvroRow(record) === Row(Seq(new BigDecimal(expected))))
    }
  }

  test("parse avro fixed with decimal as Java BigDecimal type") {
    val schema = getLogicalSchema(
      s"""|{
          |   "name":"fixed",
          |   "type":"fixed",
          |   "size":5,
          |   "logicalType":"decimal",
          |   "precision":4,
          |   "scale":2
          |}""".stripMargin
    )
    decimals.foreach { case (given, expected) =>
      val record = new GenericData.Record(schema)
      val fixed = new Conversions.DecimalConversion().toFixed(
        new BigDecimal(given).setScale(scale),
        schema.getField("value").schema(),
        LogicalTypes.decimal(precision, scale)
      )
      record.put("value", fixed)
      assert(AvroRow(record) === Row(Seq(new BigDecimal(expected))))
    }
  }

  test("throws if avro decimal exceeds allowed precision") {
    val schema = getLogicalSchema(
      s"""|{
          |   "type":"bytes",
          |   "logicalType":"decimal",
          |   "precision":40,
          |   "scale":0
          |}""".stripMargin
    )
    val record = new GenericData.Record(schema)
    val bigDecimal = new BigDecimal("1234567890123456789012345678901234567890")
    val bytes = ByteBuffer.wrap(bigDecimal.unscaledValue().toByteArray())
    record.put("value", bytes)
    val thrown = intercept[IllegalArgumentException] {
      AvroRow(record)
    }
    val expected = "Decimal precision 40 is larger than maximum allowed precision 36."
    assert(thrown.getMessage() === expected)
  }

}
