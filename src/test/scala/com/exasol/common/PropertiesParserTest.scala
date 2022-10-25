package com.exasol.common

import nl.jqno.equalsverifier.EqualsVerifier
import org.scalatest.funsuite.AnyFunSuite

class PropertiesParserTest extends AnyFunSuite {

  private[this] val parser = PropertiesParser(";", "=")

  test("mapFromString empty string throws") {
    val thrown = intercept[IllegalArgumentException] {
      parser.mapFromString("")
    }
    assert(thrown.getMessage().contains("Properties input string does not contain key-value assignment '='."))
  }

  test("mapTo/FromString parses to/from key value map") {
    val testData = Map(
      "key=value" -> Map("key" -> "value"),
      "a=1;b=2;c=3" -> Map("a" -> "1", "b" -> "2", "c" -> "3")
    )
    testData.foreach { case (given, expected) =>
      assert(parser.mapFromString(given) === expected)
      assert(parser.mapToString(expected) === given)
    }
  }

  test("mapToString returns empty string from empty map") {
    assert(parser.mapToString(Map.empty[String, String]) === "")
  }

  test("verify contract") {
    EqualsVerifier.forClass(classOf[PropertiesParser]).verify()
  }

}
