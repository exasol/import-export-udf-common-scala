package com.exasol.common.avro

import java.util.{List => JList}
import java.util.{Map => JMap}

import com.exasol.common.data.Row

import org.apache.avro.Schema
import org.apache.avro.generic.GenericData
import org.scalatest.funsuite.AnyFunSuite

class AvroComplexTypesTest extends AnyFunSuite {

  private[this] def getArraySchema(avroType: String): Schema =
    new Schema.Parser()
      .parse(
        s"""|{
            |  "type": "record",
            |  "namespace": "com.exasol.avro.Types",
            |  "name": "ArrayRecord",
            |  "fields": [{
            |    "name": "value",
            |    "type": {"type":"array","items":$avroType}
            |  }]
            |}
            |""".stripMargin
      )

  private[this] def getMapSchema(avroType: String): Schema =
    new Schema.Parser()
      .parse(
        s"""|{
            |  "type": "record",
            |  "namespace": "com.exasol.avro.Types",
            |  "name": "MapRecord",
            |  "fields": [{
            |    "name": "value",
            |    "type": {"type":"map","values":$avroType}
            |  }]
            |}
            |""".stripMargin
      )

  private[this] def getRecordSchema(avroRecordType: String): Schema =
    new Schema.Parser()
      .parse(
        s"""|{
            |  "type": "record",
            |  "namespace": "com.exasol.avro.Types",
            |  "name": "MapRecord",
            |  "fields": [
            |     {"name": "id", "type":"int"},
            |     $avroRecordType
            |  ]
            |}
            |""".stripMargin
      )

  test("parse avro array type") {
    val schema = getArraySchema("\"boolean\"")
    val record = new GenericData.Record(schema)
    record.put("value", Array(true, false, true))
    assert(AvroRow(record) === Row(Seq("[true,false,true]")))
  }

  test("parse avro Java collection type") {
    val schema = getArraySchema("\"double\"")
    val record = new GenericData.Record(schema)
    record.put("value", JList.of(1.2d, 3.14d, 2.71D))
    assert(AvroRow(record) === Row(Seq("[1.2,3.14,2.71]")))
  }

  test("parse avro array of records type") {
    val innerRecordSchemaString =
      s"""|{
          |"type":"record",
          |"name":"Record",
          |"fields":[
          |   {"name":"name","type":"string"},
          |   {"name":"salary","type":"double"}
          |]}
      """.stripMargin
    val innerRecordSchema = new Schema.Parser().parse(innerRecordSchemaString)
    val schema = getArraySchema(innerRecordSchemaString)

    val recordA = new GenericData.Record(innerRecordSchema)
    recordA.put("name", "abc")
    recordA.put("salary", 3.14)

    val recordB = new GenericData.Record(innerRecordSchema)
    recordB.put("name", "xyz")
    recordB.put("salary", 2.71)

    val record = new GenericData.Record(schema)
    record.put("value", JList.of(recordA, recordB))

    val expected = """[{"name":"abc","salary":3.14},{"name":"xyz","salary":2.71}]"""
    assert(AvroRow(record) === Row(Seq(expected)))
  }

  test("throws unsupported array type") {
    val schema = getArraySchema("""{"type":"map", "values":"int"}""")
    val record = new GenericData.Record(schema)
    record.put("value", JMap.of("k1", 1, "k2", 2, "k3", 3))
    val thrown = intercept[IllegalArgumentException] {
      AvroRow(record)
    }
    assert(thrown.getMessage.contains("Unsupported Avro Array type"))
  }

  test("parse avro map type") {
    val schema = getMapSchema("\"int\"")
    val record = new GenericData.Record(schema)
    record.put("value", JMap.of("k1", 1, "k2", 2, "k3", 3))
    assert(AvroRow(record) === Row(Seq("""{"k1":1,"k2":2,"k3":3}""")))
  }

  test("parse avro map of arrays type") {
    val schema = getMapSchema("""{"type":"array","items":"int"}""")
    val record = new GenericData.Record(schema)
    record.put("value", JMap.of("k1", JList.of(1, 2, 3), "k2", JList.of(5, 6)))
    assert(AvroRow(record) === Row(Seq("""{"k1":[1,2,3],"k2":[5,6]}""")))
  }

  private[this] val addressSchemaString =
    s"""|{
        |"type":"record",
        |"name":"AddressRecord",
        |"fields":[
        |   {"name":"street","type":"string"},
        |   {"name":"zipCode","type":"long"}
        |]}
      """.stripMargin
  private[this] val addressSchema = new Schema.Parser().parse(addressSchemaString)

  test("parse avro record") {
    val schema = getRecordSchema(s"""{"name":"address","type":$addressSchemaString}""")
    val address = new GenericData.Record(addressSchema)
    address.put("street", "Street 9")
    address.put("zipCode", 40902)
    val record = new GenericData.Record(schema)
    record.put("id", 1)
    record.put("address", address)
    val row = AvroRow(record)
    assert(row.getAs[Int](0) === 1)
    assert(row.getAs[String](1) === """{"zipCode":40902,"street":"Street 9"}""")
  }

  test("parse nested record") {
    val personSchemaString =
      s"""|{
          |"type":"record",
          |"name":"PersonRecord",
          |"fields":[
          |   {"name":"name","type":"string"},
          |   {"name":"surname","type":"string"},
          |   {"name":"age","type":"int"},
          |   {"name":"address","type":$addressSchemaString}
          |]}
      """.stripMargin
    val personSchema = new Schema.Parser().parse(personSchemaString)
    val schema = getRecordSchema(s"""{"name":"person","type":$personSchemaString}""")

    val address = new GenericData.Record(addressSchema)
    address.put("street", "Street9")
    address.put("zipCode", 40902)

    val person = new GenericData.Record(personSchema)
    person.put("name", "John")
    person.put("surname", "Doe")
    person.put("age", 42)
    person.put("address", address)

    val record = new GenericData.Record(schema)
    record.put("id", 1)
    record.put("person", person)

    val expected =
      s"""|{
          |   "address":{"zipCode":40902,"street":"Street9"},
          |   "surname":"Doe",
          |   "name":"John",
          |   "age":42
          |}""".stripMargin.replaceAll("\\s+", "")
    val row = AvroRow(record)
    assert(row.getAs[Int](0) === 1)
    assert(row.getAs[String](1) === expected)
  }

  test("throws unsupported record type") {
    val schema = getRecordSchema(s"""{"name":"address","type":$addressSchemaString}""")
    val record = new GenericData.Record(schema)
    record.put("id", 1)
    record.put("address", "str")
    val thrown = intercept[IllegalArgumentException] {
      AvroRow(record)
    }
    assert(thrown.getMessage.contains("Unsupported Avro Record type"))
  }

}
