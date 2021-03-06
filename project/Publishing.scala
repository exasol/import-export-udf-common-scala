package com.exasol.common.sbt

import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtGit.git
import com.jsuereth.sbtpgp.PgpKeys._
import scala.xml.transform.RewriteRule
import scala.xml.transform.RuleTransformer

object Publishing {

  val VersionRegex = "v([0-9]+.[0-9]+.[0-9]+)-?(.*)?".r

  def publishSettings(): Seq[Setting[_]] = Seq(
    homepage := Some(url("https://github.com/exasol/import-export-udf-common-scala")),
    licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT")),
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := Function.const(false),
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/exasol/import-export-udf-common-scala"),
        "scm:git:git@github.com:exasol/import-export-udf-common-scala.git"
      )
    ),
    developers := List(
      Developer(
        id = "exasol",
        name = "Exasol AG",
        email = "opensource@exasol.com",
        url = url("https://github.com/exasol/")
      )
    ),
    // Do not include scoverage & wartremover plugins as a dependency in the pom
    // https://github.com/scoverage/sbt-scoverage/issues/153
    // This code was copied from https://github.com/http4s/http4s
    pomPostProcess := { (node: xml.Node) =>
      val depsToRemove = Set("org.scoverage", "org.wartremover", "org.danielnixon")
      new RuleTransformer(new RewriteRule {
        override def transform(node: xml.Node): Seq[xml.Node] = node match {
          case e: xml.Elem
              if e.label == "dependency" && e.child
                .exists(child => child.label == "groupId" && depsToRemove.contains(child.text)) =>
            Nil
          case _ => Seq(node)
        }
      }).transform(node).head
    },
    // Gnupg related settings
    // Global scope somehow needed here; otherwise publishLocalSigned looks for these credentials
    // in default path of ~/.sbt/gpg/
    useGpg in Global := false,
    pgpPublicRing in Global := baseDirectory.value / "project" / ".gnupg" / "local.pubring.asc",
    pgpSecretRing in Global := baseDirectory.value / "project" / ".gnupg" / "local.secring.asc",
    pgpPassphrase in Global := sys.env.get("PGP_PASSPHRASE").map(_.toArray),
    credentials ++= (for {
      username <- sys.env.get("SONATYPE_USERNAME")
      password <- sys.env.get("SONATYPE_PASSWORD")
    } yield
      Credentials(
        "Sonatype Nexus Repository Manager",
        "oss.sonatype.org",
        username,
        password
      )).toSeq,
    // git.baseVersion setting represents previously released version
    git.baseVersion := "0.1.0",
    git.gitTagToVersionNumber := {
      case VersionRegex(v, "")         => Some(v)
      case VersionRegex(v, "SNAPSHOT") => Some(s"$v-SNAPSHOT")
      case VersionRegex(v, s)          => Some(s"$v-$s-SNAPSHOT")
      case _                           => None
    },
    git.formattedShaVersion := {
      val suffix = git.makeUncommittedSignifierSuffix(
        git.gitUncommittedChanges.value,
        git.uncommittedSignifier.value
      )
      git.gitHeadCommit.value map { _.substring(0, 7) } map { sha =>
        git.baseVersion.value + "-" + sha + suffix
      }
    }
  )

  def noPublishSettings: Seq[Setting[_]] = Seq(
    publish := {},
    publishLocal := {},
    publishArtifact := false
  )

}
