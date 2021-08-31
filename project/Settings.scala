package com.exasol.common.sbt

import sbt._
import sbt.Keys._

import com.typesafe.sbt.SbtGit.git
import scoverage.ScoverageSbtPlugin.autoImport._
import org.scalastyle.sbt.ScalastylePlugin.autoImport._
import wartremover.WartRemover.autoImport.wartremoverErrors

/** A list of (boilerplate) settings for build process */
object Settings {

  def projectSettings(scalaVersion: SettingKey[String]): Seq[Setting[_]] =
    buildSettings(scalaVersion) ++ miscSettings ++ scalaStyleSettings ++ Publishing
      .publishSettings()

  def buildSettings(scalaVersion: SettingKey[String]): Seq[Setting[_]] = Seq(
    // Compiler settings
    scalacOptions ++= Compilation.compilerFlagsFn(scalaVersion.value),
    Compile / console / scalacOptions := Compilation.consoleFlagsFn(scalaVersion.value),
    javacOptions ++= Compilation.JavacCompilerFlags,
    Compile / compileOrder := CompileOrder.JavaThenScala
  )

  def miscSettings(): Seq[Setting[_]] = Seq(
    // Wartremover settings
    Compile / compile / wartremoverErrors := Compilation.WartremoverFlags,
    Test / compile / wartremoverErrors := Compilation.WartremoverTestFlags,
    // General settings
    Global / cancelable := true,
    // Scoverage settings
    coverageOutputHTML := true,
    coverageOutputXML := true,
    coverageOutputCobertura := true,
    coverageFailOnMinimum := false,
    // Git versioning, use git describe
    git.useGitDescribe := true
  )

  /** Creates a Scalastyle tasks that run with unit and integration tests. */
  def scalaStyleSettings(): Seq[Setting[_]] = {
    lazy val mainScalastyle = taskKey[Unit]("mainScalastyle")
    lazy val testScalastyle = taskKey[Unit]("testScalastyle")
    Seq(
      scalastyleFailOnError := true,
      Compile / scalastyleConfig := (ThisBuild / baseDirectory).value / "project" / "scalastyle-config.xml",
      Test / scalastyleConfig := (ThisBuild / baseDirectory).value / "project" / "scalastyle-test-config.xml",
      mainScalastyle := (Compile / scalastyle).toTask("").value,
      testScalastyle := (Compile / scalastyle).toTask("").value,
      Test / test := (Test / test).dependsOn(mainScalastyle).value,
      Test / test := (Test / test).dependsOn(testScalastyle).value
    )
  }

}
