package com.exasol.common.avro

import com.exasol.common.data.Row

import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.scalatest.funsuite.AnyFunSuite

class AvroPrimitiveReaderTest extends AnyFunSuite {

  private[this] def getSchema(avroType: String): Schema =
    new Schema.Parser()
      .parse(
        s"""|{
            |  "type": "record",
            |  "namespace": "com.exasol.avro.Types",
            |  "name": "PrimitiveRecord",
            |  "fields": [{
            |    "name": "value",
            |    "type": $avroType
            |  }]
            |}
            |""".stripMargin
      )

  test("parse avro null type") {
    val record = new GenericData.Record(getSchema("\"null\""))
    record.put("value", null)
    assert(AvroRow(record) === Row(Seq(null)))
  }

  test("parse avro boolean type") {
    val record = new GenericData.Record(getSchema("\"boolean\""))
    record.put("value", true)
    assert(AvroRow(record) === Row(Seq(true)))
  }

  test("parse avro int type") {
    val record = new GenericData.Record(getSchema("\"int\""))
    record.put("value", 123)
    assert(AvroRow(record) === Row(Seq(123)))
  }

  test("parse avro long type") {
    val record = new GenericData.Record(getSchema("\"long\""))
    record.put("value", 123456L)
    assert(AvroRow(record) === Row(Seq(123456L)))
  }

  test("parse avro float type") {
    val record = new GenericData.Record(getSchema("\"float\""))
    record.put("value", 3.14f)
    assert(AvroRow(record) === Row(Seq(3.14f)))
  }

  test("parse avro double type") {
    val record = new GenericData.Record(getSchema("\"double\""))
    record.put("value", 2.71d)
    assert(AvroRow(record) === Row(Seq(2.71d)))
  }

  test("parse avro union null first type") {
    val schema = getSchema(s"""["null", "string"]""")
    unionTest(schema)
  }

  test("parse avro union null second type") {
    val schema = getSchema(s"""["string", "null"]""")
    unionTest(schema)
  }

  test("parse avro union with many types") {
    assertThrowsUnionError(getSchema(s"""["string", "int", "null"]"""))
  }

  test("parse avro union without a null type") {
    assertThrowsUnionError(getSchema(s"""["string", "int"]"""))
  }

  private[this] def assertThrowsUnionError(schema: Schema): Unit = {
    val thrown = intercept[IllegalArgumentException] {
      unionTest(schema)
    }
    assert(thrown.getMessage().startsWith("E-IEUCS-7: Avro union type does not contain a primitive type and null."))
    ()
  }

  private[this] def unionTest(schema: Schema): Unit = {
    val record1 = new GenericData.Record(schema)
    record1.put("value", "hello")
    assert(AvroRow(record1) === Row(Seq("hello")))
    val record2 = new GenericData.Record(schema)
    record2.put("value", null)
    assert(AvroRow(record2) === Row(Seq(null)))
    ()
  }

}
