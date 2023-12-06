# Import Export UDF Common Scala 2.0.0, released 2023-12-06

Code name: Remove dependencies from JAR

## Summary

Previous releases of this project contained all dependencies in the published JAR file (i.e. fat JAR). This project is a library that is used in other projects and should not contain dependencies in the JAR, so we removed them.

## Bugfixes

* #54: Removed dependencies from published JAR

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:udf-api-java:1.0.2` to `1.0.4`
* Updated `com.fasterxml.jackson.core:jackson-databind:2.15.0` to `2.16.0`
* Updated `com.fasterxml.jackson.module:jackson-module-scala_2.13:2.15.0` to `2.16.0`
* Removed `org.slf4j:slf4j-simple:2.0.7`

### Test Dependency Updates

* Updated `nl.jqno.equalsverifier:equalsverifier:3.14.1` to `3.15.4`
* Updated `org.mockito:mockito-core:5.3.1` to `5.8.0`
* Updated `org.scalatestplus:scalatestplus-mockito_2.13:1.0.0-M2` to `1.0.0-SNAP5`
* Updated `org.scalatest:scalatest_2.13:3.2.13` to `3.3.0-SNAP4`
* Added `org.slf4j:slf4j-simple:2.0.9`

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:2.9.16` to `2.9.17`
* Removed `org.apache.maven.plugins:maven-assembly-plugin:3.5.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.1` to `2.16.2`
