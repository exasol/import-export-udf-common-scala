package com.exasol.common.sbt

import sbt.{ExclusionRule, _}

/** A list of required dependencies */
object Dependencies {

  // Runtime dependencies versions
  private val ExasolVersion = "6.1.7"
  private val AvroVersion = "1.10.2"
  private val JacksonVersion = "2.12.5"
  private val TypesafeLoggingVersion = "3.9.4"
  private val SLF4JSimpleVersion = "1.7.32"

  // Test dependencies versions
  private val ScalaTestVersion = "3.2.10"
  private val ScalaTestPlusVersion = "1.0.0-M2"
  private val MockitoCoreVersion = "4.0.0"

  val ExasolResolvers: Seq[Resolver] = Seq(
    "Exasol Releases" at "https://maven.exasol.com/artifactory/exasol-releases"
  )

  lazy val RuntimeDependencies: Seq[ModuleID] = Seq(
    "com.exasol" % "exasol-script-api" % ExasolVersion,
    "org.slf4j" % "slf4j-simple" % SLF4JSimpleVersion,
    "com.exasol" % "error-reporting-java" % "0.4.0",
    "com.typesafe.scala-logging" %% "scala-logging" % TypesafeLoggingVersion
      exclude ("org.slf4j", "slf4j-api")
      exclude ("org.scala-lang", "scala-library")
      exclude ("org.scala-lang", "scala-reflect"),
    "org.apache.avro" % "avro" % AvroVersion
      exclude ("org.slf4j", "slf4j-api")
      excludeAll (
        ExclusionRule(organization = "com.fasterxml.jackson.core"),
        ExclusionRule(organization = "com.fasterxml.jackson.module")
      ),
    "com.fasterxml.jackson.core" % "jackson-databind" % JacksonVersion,
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % JacksonVersion
  )

  lazy val TestDependencies: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % ScalaTestVersion,
    "org.scalatestplus" %% "scalatestplus-mockito" % ScalaTestPlusVersion,
    "org.mockito" % "mockito-core" % MockitoCoreVersion
  ).map(_ % Test)

  lazy val AllDependencies: Seq[ModuleID] = RuntimeDependencies ++ TestDependencies

}
