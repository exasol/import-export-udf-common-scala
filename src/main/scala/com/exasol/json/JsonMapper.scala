package com.exasol.common.json

import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.json.{ JsonMapper => BaseJsonMapper }
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object JsonMapper {

  private[this] val mapper = BaseJsonMapper
    .builder()
    .addModule(DefaultScalaModule)
    .build()

  def toJson[T](value: T): String =
    mapper.writeValueAsString(value)

  def parseJson[T: Manifest](jsonString: String): T =
    mapper.readValue[T](jsonString, new TypeReference[T]() {})

}
