package com.exasol.common.data

/**
 * The internal class that holds column data in an array.
 */
final case class Row(protected[data] val values: Seq[Any]) {

  /** Checks whether the value at position {@code index} is null. */
  def isNullAt(index: Int): Boolean = get(index) == null

  /**
   * Returns the value at position {@code index}.
   *
   * If the value is null, null is returned.
   */
  @throws[IndexOutOfBoundsException]("When index is out of bounds")
  def get(index: Int): Any = values(index)

  /** Returns the value at position {@code index} casted to the type. */
  @throws[ClassCastException]("When data type does not match")
  def getAs[T](index: Int): T = get(index).asInstanceOf[T]

  /** Returns the value array. */
  def getValues(): Seq[Any] =
    values

}
