package com.exasol.common.json

import org.scalatest.funsuite.AnyFunSuite

class JsonMapperTest extends AnyFunSuite {

  test("parse to and from json to internal data type") {
    val jsonStr = """{"name":"John","age":30,"skills":["a","b","c"]}"""
    val map = JsonMapper.parseJson[Map[String, Any]](jsonStr)
    assert(map.get("skills") === Option(Seq("a", "b", "c")))
    assert(JsonMapper.toJson(map) === jsonStr)
  }

}
