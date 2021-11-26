package com.exasol.common.json

import java.util.LinkedHashMap

import com.fasterxml.jackson.databind.JsonNode
import org.scalatest.funsuite.AnyFunSuite

class JsonMapperTest extends AnyFunSuite {

  test("parses to/from JSON to internal Scala data type") {
    val jsonStr = """{"name":"John","age":30,"skills":["a","b","c"]}"""
    val map = JsonMapper.fromJson[Map[String, Any]](jsonStr)
    assert(map.get("skills") === Option(Seq("a", "b", "c")))
    assert(JsonMapper.toJson(map) === jsonStr)
  }

  test("parses to/from JSON to JsonNode") {
    val jsonStr =
      """|{
         |  "number" : 1,
         |  "record" : {
         |    "field1" : "value1",
         |    "field2" : 23
         |  }
         |}""".stripMargin
    val jsonNode = JsonMapper.fromJson[JsonNode](jsonStr)
    assert(JsonMapper.toPrettyJson(jsonNode) === jsonStr)
  }

  test("parses to/from JSON to Java LinkedHashMap") {
    val jsonStr = """{"name":"John","age":"ten"}"""
    val expected = new LinkedHashMap[String, String](java.util.Map.of("name", "John", "age", "ten"))
    val parsedMap = JsonMapper.fromJson[LinkedHashMap[String, String]](jsonStr)
    assert(parsedMap === expected)
    assert(JsonMapper.toJson(parsedMap) === jsonStr)
  }

}
