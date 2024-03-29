# Import Export UDF Common Scala 0.4.0, released 2022-02-18

Code name: Migrated to maven build

## Summary

In this release, we migrated to the Maven based build and refactored the Continuous Integration (CI) workflow files that contain matrix builds.

## Bug Fixes

* #30: Added name to release droid workflow file with matrix build

## Features

* #27: Migrated to `maven` based build

## Dependency Updates

### Compile Dependency Updates

* Added `com.exasol:error-reporting-java:0.4.1`
* Added `com.exasol:exasol-script-api:6.1.7`
* Added `com.fasterxml.jackson.core:jackson-databind:2.12.5`
* Added `com.fasterxml.jackson.module:jackson-module-scala_2.13:2.12.5`
* Added `com.typesafe.scala-logging:scala-logging_2.13:3.9.4`
* Added `org.apache.avro:avro:1.11.0`
* Added `org.scala-lang:scala-library:2.13.8`
* Added `org.slf4j:slf4j-simple:1.7.36`

### Test Dependency Updates

* Added `org.mockito:mockito-core:4.3.1`
* Added `org.scalatestplus:scalatestplus-mockito_2.13:1.0.0-M2`
* Added `org.scalatest:scalatest_2.13:3.2.10`

### Plugin Dependency Updates

* Added `com.diffplug.spotless:spotless-maven-plugin:2.20.2`
* Added `com.exasol:error-code-crawler-maven-plugin:1.0.0`
* Added `com.exasol:project-keeper-maven-plugin:1.3.4`
* Added `io.github.evis:scalafix-maven-plugin_2.13:0.1.4_0.9.33`
* Added `io.github.zlika:reproducible-build-maven-plugin:0.15`
* Added `net.alchim31.maven:scala-maven-plugin:4.5.6`
* Added `org.apache.maven.plugins:maven-assembly-plugin:3.3.0`
* Added `org.apache.maven.plugins:maven-clean-plugin:3.1.0`
* Added `org.apache.maven.plugins:maven-compiler-plugin:3.10.0`
* Added `org.apache.maven.plugins:maven-deploy-plugin:3.0.0-M1`
* Added `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0`
* Added `org.apache.maven.plugins:maven-gpg-plugin:3.0.1`
* Added `org.apache.maven.plugins:maven-install-plugin:2.5.2`
* Added `org.apache.maven.plugins:maven-jar-plugin:3.2.2`
* Added `org.apache.maven.plugins:maven-javadoc-plugin:3.3.2`
* Added `org.apache.maven.plugins:maven-resources-plugin:3.2.0`
* Added `org.apache.maven.plugins:maven-site-plugin:3.11.0`
* Added `org.apache.maven.plugins:maven-source-plugin:3.2.1`
* Added `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4`
* Added `org.codehaus.mojo:versions-maven-plugin:2.9.0`
* Added `org.itsallcode:openfasttrace-maven-plugin:1.4.0`
* Added `org.scalastyle:scalastyle-maven-plugin:1.0.0`
* Added `org.scalatest:scalatest-maven-plugin:2.0.2`
* Added `org.scoverage:scoverage-maven-plugin:1.4.11`
* Added `org.sonatype.ossindex.maven:ossindex-maven-plugin:3.2.0`
* Added `org.sonatype.plugins:nexus-staging-maven-plugin:1.6.8`
