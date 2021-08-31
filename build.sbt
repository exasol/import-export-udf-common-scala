import com.exasol.common.sbt.Dependencies
import com.exasol.common.sbt.Settings

lazy val orgSettings = Seq(
  name := "import-export-udf-common-scala",
  description := "Common Import Export Libraries used in Exasol User Defined Functions",
  organization := "com.exasol",
  organizationHomepage := Some(url("http://www.exasol.com"))
)

lazy val buildSettings = Seq(
  scalaVersion := "2.13.6",
  crossScalaVersions := Seq("2.12.14", "2.13.6")
)

lazy val root =
  project
    .in(file("."))
    .settings(moduleName := "import-export-udf-common-scala")
    .settings(orgSettings)
    .settings(buildSettings)
    .settings(Settings.projectSettings(scalaVersion))
    .settings(
      resolvers ++= Dependencies.ExasolResolvers,
      libraryDependencies ++= Dependencies.AllDependencies
    )
    .enablePlugins(GitVersioning)

addCommandAlias("pluginUpdates", ";reload plugins;dependencyUpdates;reload return")
