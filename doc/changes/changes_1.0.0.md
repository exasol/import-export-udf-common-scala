# Import Export UDF Common Scala 1.0.0, released 2022-10-26

Code name: Fix vulnerabilities in dependencies

## Summary

This is release is a breaking change as it removes support for Scala 2.12, it only supports Scala 2.13. It also updates the following dependencies to fix vulnerabilities:
* com.fasterxml.jackson.core:jackson-databind:jar:2.12.7:compile:
  * CVE-2022-42003 CWE-502: Deserialization of Untrusted Data (7.5)
  * CVE-2022-42004 CWE-502: Deserialization of Untrusted Data (7.5)
* org.scala-lang:scala-library:jar:2.13.8:compile:
  * CVE-2022-36944 CWE-502: Deserialization of Untrusted Data (9.8)

## Features

* #40: Fixed vulnerabilities in dependencies

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:error-reporting-java:0.4.1` to `1.0.0`
* Updated `com.fasterxml.jackson.core:jackson-databind:2.12.7` to `2.13.4.2`
* Updated `com.fasterxml.jackson.module:jackson-module-scala_2.13:2.12.7` to `2.13.4`
* Updated `org.scala-lang:scala-library:2.13.8` to `2.13.10`

### Test Dependency Updates

* Added `nl.jqno.equalsverifier:equalsverifier:3.10.1`
* Updated `org.mockito:mockito-core:4.6.1` to `4.8.1`

### Plugin Dependency Updates

* Updated `com.exasol:error-code-crawler-maven-plugin:1.1.1` to `1.1.2`
* Updated `com.exasol:project-keeper-maven-plugin:2.5.0` to `2.8.0`
* Updated `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0` to `3.1.0`
* Updated `org.itsallcode:openfasttrace-maven-plugin:1.4.0` to `1.5.0`
* Removed `org.scoverage:scoverage-maven-plugin:1.4.11`
