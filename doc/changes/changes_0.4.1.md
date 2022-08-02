# Import Export UDF Common Scala 0.4.1, released 2022-08-02

Code name: Upgrade dependencies to fix vulnerabilities

## Summary

This release fixes vulnerabilities in the following dependencies:

* com.fasterxml.jackson.core:jackson-databind:jar:2.12.5 in compile
    * CVE-2020-36518, severity CWE-787: Out-of-bounds Write (7.5)
    * [sonatype-2021-4682](https://ossindex.sonatype.org/vulnerability/sonatype-2021-4682), severity CWE-400: Uncontrolled Resource Consumption ('Resource Exhaustion')

## Bugfixes

* #33: Upgrade dependencies to fix vulnerabilities

## Dependency Updates

### Compile Dependency Updates

* Updated `com.fasterxml.jackson.core:jackson-databind:2.12.5` to `2.12.7`
* Updated `com.fasterxml.jackson.module:jackson-module-scala_2.13:2.12.5` to `2.12.7`
* Updated `com.typesafe.scala-logging:scala-logging_2.13:3.9.4` to `3.9.5`
* Updated `org.apache.avro:avro:1.11.0` to `1.11.1`

### Test Dependency Updates

* Updated `org.mockito:mockito-core:4.3.1` to `4.6.1`
* Updated `org.scalatest:scalatest_2.13:3.2.10` to `3.2.13`

### Plugin Dependency Updates

* Updated `com.diffplug.spotless:spotless-maven-plugin:2.20.2` to `2.22.8`
* Updated `com.exasol:error-code-crawler-maven-plugin:1.0.0` to `1.1.1`
* Updated `com.exasol:project-keeper-maven-plugin:1.3.4` to `2.5.0`
* Updated `io.github.evis:scalafix-maven-plugin_2.13:0.1.4_0.9.33` to `0.1.6_0.10.0`
* Updated `net.alchim31.maven:scala-maven-plugin:4.5.6` to `4.6.3`
* Updated `org.apache.maven.plugins:maven-clean-plugin:3.1.0` to `2.5`
* Updated `org.apache.maven.plugins:maven-compiler-plugin:3.10.0` to `3.10.1`
* Updated `org.apache.maven.plugins:maven-install-plugin:2.5.2` to `2.4`
* Updated `org.apache.maven.plugins:maven-jar-plugin:3.2.2` to `2.4`
* Updated `org.apache.maven.plugins:maven-javadoc-plugin:3.3.2` to `3.4.0`
* Updated `org.apache.maven.plugins:maven-resources-plugin:3.2.0` to `2.6`
* Updated `org.apache.maven.plugins:maven-site-plugin:3.11.0` to `3.3`
* Updated `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M4` to `3.0.0-M5`
* Added `org.codehaus.mojo:flatten-maven-plugin:1.2.7`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.9.0` to `2.10.0`
* Added `org.jacoco:jacoco-maven-plugin:0.8.8`
* Added `org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184`
* Updated `org.sonatype.plugins:nexus-staging-maven-plugin:1.6.8` to `1.6.13`
