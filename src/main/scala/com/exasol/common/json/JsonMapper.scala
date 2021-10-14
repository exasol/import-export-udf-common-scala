package com.exasol.common.json

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.json.{JsonMapper => BaseJsonMapper}
import com.fasterxml.jackson.module.scala.ClassTagExtensions

/**
 * JSON parsing helper object class.
 */
object JsonMapper {

  private[this] class ScalaJsonMapper(jsonMapper: BaseJsonMapper)
      extends BaseJsonMapper(jsonMapper)
      with ClassTagExtensions

  private[this] val mapper = {
    val builder = BaseJsonMapper
      .builder()
      .findAndAddModules()
      .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
      .enable(JsonParser.Feature.ALLOW_COMMENTS)
      .defaultMergeable(true)
    new ScalaJsonMapper(builder.build())
  }

  /**
   * Parses given value type into a JSON string.
   *
   * For parsing into pretty indented JSON use {@link toPrettyJson}.
   *
   * @param value a provided value type
   * @return JSON string
   */
  def toJson[T](value: T): String =
    mapper.writeValueAsString(value)

  /**
   * Parses given value into pretty JSON format.
   *
   * @param value a provided value type
   * @return pretty JSON string
   */
  def toPrettyJson[T](value: T): String =
    mapper.writer(SerializationFeature.INDENT_OUTPUT).writeValueAsString(value)

  /**
   * Parses JSON string into a type.
   *
   * @param jsonString a JSON string
   * @return parsed value
   */
  def fromJson[T: Manifest](jsonString: String): T =
    mapper.readValue[T](jsonString)

  /**
   * Parses JSON string into a type.
   *
   * @param jsonString a JSON string
   * @return parsed value
   */
  @deprecated("Use fromJson method instead.", "0.3.1")
  def parseJson[T: Manifest](jsonString: String): T =
    fromJson(jsonString)

}
