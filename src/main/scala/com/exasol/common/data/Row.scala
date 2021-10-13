package com.exasol.common.data

import scala.reflect.ClassTag

import com.exasol.errorreporting.ExaError

/**
 * The internal class that holds column data in an array.
 */
final case class Row(protected[data] val values: Seq[Any]) {

  /**
   * Checks whether the value at position {@code index} is null.
   *
   * @param index an index into value array
   * @return {@code true} if value at index is {@code null}, otherwise {@code false}
   */
  def isNullAt(index: Int): Boolean = get(index) == null

  /**
   * Returns the value at position {@code index}.
   *
   * If the value is null, null is returned.
   *
   * @param index an index into values array
   * @return value at the provided index
   */
  @throws[IndexOutOfBoundsException]("When index is out of bounds")
  def get(index: Int): Any =
    if (index >= values.length) {
      throw new IndexOutOfBoundsException(
        ExaError
          .messageBuilder("E-IEUCS-10")
          .message("Given index {{INDEX}} is out of bounds.", String.valueOf(index))
          .mitigation("Please use correct index to obtain field value.")
          .toString()
      )
    } else {
      values(index)
    }

  /**
   * Returns the value at position {@code index} casted to the type.
   *
   * For catching {@link java.lang.ClassCastException}, we use reflection based casting.
   *
   * @param index an index into values array
   * @return value at the provided index casted to type
   */
  @throws[IllegalArgumentException]("When data type does not match")
  def getAs[T](index: Int)(implicit m: ClassTag[T]): T = {
    val runtimeClass = m.runtimeClass
    val value = get(index)
    try {
      runtimeClass.cast(value).asInstanceOf[T]
    } catch {
      case exception: ClassCastException =>
        throw new IllegalArgumentException(
          ExaError
            .messageBuilder("E-IEUCS-11")
            .message("Failed to cast {{VALUE}} at index {{INDEX}} to instance of {{INSTANCE_TYPE}}.")
            .parameter("VALUE", value)
            .parameter("INDEX", String.valueOf(index))
            .parameter("INSTANCE_TYPE", runtimeClass.toString())
            .mitigation("Please use valid type parameter for type casting.")
            .toString(),
          exception
        )
    }
  }

  /** Returns the value array. */
  def getValues(): Seq[Any] =
    values

}
