# Import Export UDF Common Scala 0.3.0, released 2021-10-13

Code name: Added custom separators

## Summary

In this release, we added custom user defined property separators and BucketFS file location checker. We also migrated our continuous integration from Travis CI to Github Actions and added unified error codes.

## Features

* #17: Added support for user provided separators

## Refactoring

* #15: Migrated to Github actions
* #18: Added unified error codes
* #20: Added file location checker

## Dependency Updates

### Runtime Dependency Updates

* Added `com.exasol:error-reporting-java:0.4.0`
* Updated `com.fasterxml.jackson.core:jackson-databind:2.11.3` to `2.12.5`
* Updated `com.fasterxml.jackson.module:jackson-module-scala:2.11.3` to `2.12.5`
* Updated `com.typesafe.scala-logging:scala-logging:3.9.2` to `3.9.4`
* Updated `org.apache.avro:avro:1.10.0` to `1.10.2`
* Updated `org.slf4j:slf4j-simple:1.7.30` to `1.7.32`

### Test Dependency Updates

* Updated `org.mockito:mockito-core:test:3.6.0` to `4.0.0`
* Updated `org.scalatest:scalatest:test:3.2.2` to `3.2.10`

### Plugin Updates

* Added `org.scalameta:sbt-scalafmt:2.4.3`
* Updated `com.jsuereth:sbt-pgp:2.0.1` to `2.1.1`
* Updated `com.timushev.sbt:sbt-updates:0.5.1` to `0.6.0`
* Updated `com.typesafe.sbt:sbt-git:1.0.0` to `1.0.2`
* Updated `org.scoverage:sbt-coveralls:1.2.7` to `1.3.1`
* Updated `org.scoverage:sbt-scoverage:1.6.1` to `1.9.1`
* Updated `org.wartremover:sbt-wartremover:2.4.12` to `2.4.16`
* Updated `org.wartremover:sbt-wartremover-contib:1.3.10` to `1.3.12`
* Updated `org.xerial.sbt:sbt-sonatype:3.9.4` to `3.9.10`
* Removed `com.github.cb372:sbt-explicit-dependencies:0.2.15`
