package com.exasol.common.avro

import java.nio.ByteBuffer

import com.exasol.common.data.Row

import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.apache.avro.generic.GenericData.EnumSymbol
import org.apache.avro.util.Utf8
import org.scalatest.funsuite.AnyFunSuite

class AvroStringReaderTest extends AnyFunSuite {

  private[this] def getSchema(avroType: String): Schema =
    new Schema.Parser()
      .parse(
        s"""|{
            |  "type": "record",
            |  "namespace": "com.exasol.avro.Types",
            |  "name": "StringRecord",
            |  "fields": [{
            |    "name": "str",
            |    "type": $avroType
            |  }]
            |}
            |""".stripMargin
      )

  test("parse avro string into string type") {
    val record = new GenericData.Record(getSchema("\"string\""))
    record.put("str", "hello")
    assert(AvroRow(record) === Row(Seq("hello")))
  }

  test("parse avro utf8 into string type") {
    val record = new GenericData.Record(getSchema("\"string\""))
    record.put("str", new Utf8("hello"))
    assert(AvroRow(record) === Row(Seq("hello")))
  }

  test("parse avro fixed type into string type") {
    val schema = getSchema(s"""{"type":"fixed","name":"fixed", "size":10}""")
    val record = new GenericData.Record(schema)
    record.put("str", Array[Byte](102, 105, 120, 101, 100))
    assert(AvroRow(record) === Row(Seq("fixed")))
  }

  test("parse avro array byte into string type") {
    val record = new GenericData.Record(getSchema("\"bytes\""))
    record.put("str", Array[Byte](104, 101, 108, 108, 111))
    assert(AvroRow(record) === Row(Seq("hello")))
  }

  test("parse avro byte buffer into string type") {
    val record = new GenericData.Record(getSchema("\"bytes\""))
    record.put("str", ByteBuffer.wrap(Array[Byte](104, 101, 108, 108, 111)))
    assert(AvroRow(record) === Row(Seq("hello")))
  }

  test("parse avro enum into string type") {
    val schema = getSchema(
      s"""|{
          |  "type":"enum",
          |  "name":"colours",
          |  "symbols":["red","blue","green"]
          |}
          |""".stripMargin
    )
    val record = new GenericData.Record(schema)
    record.put("str", new EnumSymbol(schema.getField("str").schema(), "green"))
    assert(AvroRow(record) === Row(Seq("green")))
  }

}
