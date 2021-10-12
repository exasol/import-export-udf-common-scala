package com.exasol.common.data

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class RowTest extends AnyFunSuite with Matchers {

  private[this] val values: Seq[Any] = Seq("value1", 1, 3.14, null)
  private[this] val row = Row(values)

  test("getValues returns row values") {
    assert(row.getValues() === values)
  }

  test("get value at index") {
    assert(row.get(0).isInstanceOf[String])
    assert(row.get(0) === "value1")
  }

  test("getAs[T] value at index") {
    assert(row.getAs[String](0) === "value1")
    assert(row.getAs[java.lang.Double](2) === 3.14)
  }

  test("isNuallAt returns true if null") {
    assert(row.isNullAt(3) === true)
    assert(row.isNullAt(1) === false)
  }

  test("equality check") {
    val rowEqual = Row(Seq("value1", 1, 3.14, null))
    val rowNotEqual = Row(Seq("value1", 2, 3.14, null))
    row.shouldEqual(rowEqual)
    row.should(not).equal(rowNotEqual)
  }

  test("throws class cast exception") {
    val thrown = intercept[IllegalArgumentException] {
      row.getAs[java.lang.Integer](0)
    }
    val expectedPrefix = "E-IEUCS-11: Failed to cast 'value1' at index '0' to instance of 'class java.lang.Integer'"
    assert(thrown.getMessage().startsWith(expectedPrefix))
  }

  test("throws index out of bounds") {
    val thrown = intercept[IndexOutOfBoundsException] {
      row.get(5)
    }
    assert(thrown.getMessage().startsWith("E-IEUCS-10: Given index 5 is out of bounds."))
  }

}
