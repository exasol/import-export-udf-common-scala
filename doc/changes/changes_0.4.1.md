# Import Export UDF Common Scala 0.4.1, released 2022-08-02

Code name: Upgrade dependencies to fix vulnerabilities

## Summary

This release fixes vulnerabilities in the following dependencies:

* com.fasterxml.jackson.core:jackson-databind:jar:2.12.5 in compile
    * CVE-2020-36518, severity CWE-787: Out-of-bounds Write (7.5)
    * sonatype-2021-4682

## Bugfixes

* #33: Upgrade dependencies to fix vulnerabilities

## Dependency Updates

### Compile Dependency Updates

* Added `com.exasol:error-reporting-java:0.4.1`
* Added `com.exasol:exasol-script-api:6.1.7`
* Added `com.fasterxml.jackson.core:jackson-databind:2.12.7`
* Added `com.fasterxml.jackson.module:jackson-module-scala_2.13:2.12.7`
* Added `com.typesafe.scala-logging:scala-logging_2.13:3.9.5`
* Added `org.apache.avro:avro:1.11.1`
* Added `org.scala-lang:scala-library:2.13.8`
* Added `org.slf4j:slf4j-simple:1.7.36`

### Test Dependency Updates

* Added `org.mockito:mockito-core:4.6.1`
* Added `org.scalatestplus:scalatestplus-mockito_2.13:1.0.0-M2`
* Added `org.scalatest:scalatest_2.13:3.2.13`

### Plugin Dependency Updates

* Added `com.diffplug.spotless:spotless-maven-plugin:2.22.8`
* Added `com.exasol:error-code-crawler-maven-plugin:1.1.1`
* Added `com.exasol:project-keeper-maven-plugin:2.5.0`
* Added `io.github.evis:scalafix-maven-plugin_2.13:0.1.6_0.10.0`
* Added `io.github.zlika:reproducible-build-maven-plugin:0.15`
* Added `net.alchim31.maven:scala-maven-plugin:4.6.3`
* Added `org.apache.maven.plugins:maven-assembly-plugin:3.3.0`
* Added `org.apache.maven.plugins:maven-clean-plugin:2.5`
* Added `org.apache.maven.plugins:maven-compiler-plugin:3.10.1`
* Added `org.apache.maven.plugins:maven-deploy-plugin:3.0.0-M1`
* Added `org.apache.maven.plugins:maven-enforcer-plugin:3.0.0`
* Added `org.apache.maven.plugins:maven-gpg-plugin:3.0.1`
* Added `org.apache.maven.plugins:maven-install-plugin:2.4`
* Added `org.apache.maven.plugins:maven-jar-plugin:2.4`
* Added `org.apache.maven.plugins:maven-javadoc-plugin:3.4.0`
* Added `org.apache.maven.plugins:maven-resources-plugin:2.6`
* Added `org.apache.maven.plugins:maven-site-plugin:3.3`
* Added `org.apache.maven.plugins:maven-source-plugin:3.2.1`
* Added `org.apache.maven.plugins:maven-surefire-plugin:3.0.0-M5`
* Added `org.codehaus.mojo:flatten-maven-plugin:1.2.7`
* Added `org.codehaus.mojo:versions-maven-plugin:2.10.0`
* Added `org.itsallcode:openfasttrace-maven-plugin:1.4.0`
* Added `org.jacoco:jacoco-maven-plugin:0.8.8`
* Added `org.scalastyle:scalastyle-maven-plugin:1.0.0`
* Added `org.scalatest:scalatest-maven-plugin:2.0.2`
* Added `org.scoverage:scoverage-maven-plugin:1.4.11`
* Added `org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184`
* Added `org.sonatype.ossindex.maven:ossindex-maven-plugin:3.2.0`
* Added `org.sonatype.plugins:nexus-staging-maven-plugin:1.6.13`
