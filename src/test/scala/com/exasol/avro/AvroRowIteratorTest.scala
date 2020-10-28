package com.exasol.common.avro

import java.io.File

import com.exasol.common.data.Row

import org.apache.avro.SchemaBuilder
import org.apache.avro.file.DataFileReader
import org.apache.avro.file.DataFileWriter
import org.apache.avro.generic._
import org.apache.avro.specific.SpecificDatumWriter
import org.scalatest.BeforeAndAfterEach
import org.scalatest.funsuite.AnyFunSuite

class AvroRowIteratorTest extends AnyFunSuite with BeforeAndAfterEach {

  private[this] var record: GenericData.Record = _
  private[this] val schema = SchemaBuilder
    .record("record")
    .fields()
    .requiredString("name")
    .endRecord()

  override final def beforeEach(): Unit = {
    record = new GenericData.Record(schema)
    record.put("name", "John")
    ()
  }

  test("apply returns iterator") {
    val file = File.createTempFile("record", "avro")
    file.deleteOnExit()
    write(file, record)
    val reader = new DataFileReader(file, new GenericDatumReader[GenericRecord]())
    val iterator = AvroRowIterator(reader)
    assert(iterator.hasNext === true)
    assert(iterator.next() === Row(Seq("John")))
    assert(iterator.hasNext === false)
    val thrown = intercept[NoSuchElementException] {
      iterator.next()
    }
    assert(thrown.getMessage === "Avro reader called next on an empty iterator!")
  }

  private[this] def write[T <: GenericRecord](file: File, record: T): Unit = {
    val writer = new DataFileWriter[T](new SpecificDatumWriter[T]())
    writer.create(record.getSchema, file)
    writer.append(record)
    writer.close()
  }

}
