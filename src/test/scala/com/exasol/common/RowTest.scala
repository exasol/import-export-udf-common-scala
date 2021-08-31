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
    assert(row.getAs[Double](2) === 3.14)
  }

  test("isNuallAt returns true if null") {
    assert(row.isNullAt(3) === true)
    assert(row.isNullAt(1) === false)
  }

  test("equalality check") {
    val rowEqual = Row(Seq("value1", 1, 3.14, null))
    val rowNotEqual = Row(Seq("value1", 2, 3.14, null))
    row.shouldEqual(rowEqual)
    row.should(not).equal(rowNotEqual)
  }

  test("throws class cast exception") {
    val thrown = intercept[ClassCastException] {
      row.getAs[Int](0)
    }
    val expected = "class java.lang.String cannot be cast to class java.lang.Integer"
    assert(thrown.getMessage.contains(expected))
  }

  test("throws index out of bounds") {
    val thrown = intercept[IndexOutOfBoundsException] {
      row.get(5)
    }
    assert(thrown.getMessage === "5")
  }

}
