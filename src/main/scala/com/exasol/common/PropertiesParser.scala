package com.exasol.common

import scala.collection.SortedMap

/**
 * A class that reads, serializes and deserializes key value properties to a string.
 *
 * For example, given {@code "key1=A;key2=B"} parses to a map of {@code Map('key1' -> 'A', 'key2' -> 'B')}.
 *
 * @param propertySeparator a separator for properties
 * @param keyValueAssignment an assignment for key value pairs
 */
final case class PropertiesParser(private val propertySeparator: String, private val keyValueAssignment: String) {

  /**
   * Parses properly separated input string into key-value properties map.
   *
   * @return a map of key value pairs
   */
  def mapFromString(string: String): Map[String, String] = {
    if (!string.contains(propertySeparator)) {
      throw new IllegalArgumentException(
        s"Properties input string is not separated by '$propertySeparator'."
      )
    }
    string
      .split(propertySeparator)
      .map(splitStringToTuple)
      .toMap
  }

  /**
   * Deserializes a key-value properties map into a string.
   *
   * The resulting string contains key-value pairs in a sorted order by keys.
   *
   * @return a string value of properties with provided separators
   */
  def mapToString(map: Map[String, String]): String =
    (SortedMap.empty[String, String] ++ map)
      .map { case (k, v) => s"$k$keyValueAssignment$v" }
      .mkString(propertySeparator)

  private[this] def splitStringToTuple(string: String): Tuple2[String, String] = {
    val idx = string.indexOf(keyValueAssignment)
    if (idx < 0) {
      throw new IllegalArgumentException(
        s"Properties input string does not contain key value assignment '$keyValueAssignment'."
      )
    }
    stripAndReplace(string.substring(0, idx)) -> stripAndReplace(string.substring(idx + keyValueAssignment.length()))
  }

  private[this] def stripAndReplace(string: String): String =
    string.strip().replace("\n", "")

}
