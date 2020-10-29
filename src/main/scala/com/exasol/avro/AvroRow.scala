package com.exasol.common.avro

import com.exasol.common.data.Row

import org.apache.avro.generic.GenericRecord

/**
 * A factory method that creates [[com.exasol.common.data.Row]]
 * instances from Avro [[org.apache.avro.generic.GenericRecord]] value.
 */
object AvroRow {

  /**
   * Converts an Avro record into an internal [[com.exasol.common.data.Row]].
   *
   * @param record a generic Avro record
   * @return a Row representation of the given Avro record
   */
  def apply(record: GenericRecord): Row = {
    val fields = record.getSchema().getFields()
    val size = fields.size()
    val values = Array.ofDim[Any](size)
    val converter = new AvroConverter()
    for { i <- 0 until size } {
      values.update(i, converter.convert(record.get(i), fields.get(i).schema()))
    }
    Row(values.toSeq)
  }

}
