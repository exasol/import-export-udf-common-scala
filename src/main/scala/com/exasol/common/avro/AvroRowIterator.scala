package com.exasol.common.avro

import com.exasol.common.data.Row
import com.exasol.errorreporting.ExaError

import org.apache.avro.file.DataFileReader
import org.apache.avro.generic.GenericRecord

/**
 * An object that creates a [[com.exasol.common.data.Row]] iterator
 * given the Avro [[org.apache.avro.file.DataFileReader]] with
 * [[org.apache.avro.generic.GenericRecord]].
 *
 * Each next record is converted into an internal Row class.
 */
object AvroRowIterator {

  def apply(reader: DataFileReader[GenericRecord]): Iterator[Row] =
    new Iterator[Row] {
      private[this] var isCompleted = false

      override def hasNext: Boolean =
        if (isCompleted) {
          false
        } else {
          val hasNext = reader.hasNext
          if (!hasNext) {
            reader.close()
            isCompleted = true
          }
          hasNext
        }

      override def next(): Row = {
        if (!hasNext) {
          throw new NoSuchElementException(
            ExaError
              .messageBuilder("E-IEUCS-3")
              .message("Avro reader next call on an empty iterator.")
              .mitigation("Please check that Avro iterator has elements before calling next.")
              .toString()
          )
        }
        val record = reader.next()
        AvroRow(record)
      }
    }

}
