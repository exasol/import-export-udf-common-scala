# Import Export UDF Common Scala 2.0.4, released 2026-09-15

Code name: Fixed vulnerabilities CVE-2026-19032, CVE-2026-68497

## Summary

This release fixes the following 2 vulnerabilities:

### CVE-2026-19032 (CWE-470) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
com.fasterxml.jackson.core/jackson-databind - Unrestricted URI schemes in Path deserialization
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-19032?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-19032
* https://github.com/FasterXML/jackson-databind/pull/6129

### CVE-2026-68497 (CWE-770) in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
jackson-databind - Allocation of Resources Without Limits or Throttling
#### References
* https://guide.sonatype.com/vulnerability/CVE-2026-68497?component-type=maven&component-name=com.fasterxml.jackson.core%2Fjackson-databind&utm_source=ossindex-client&utm_medium=integration&utm_content=1.8.1
* http://web.nvd.nist.gov/view/vuln/detail?vulnId=CVE-2026-68497
* https://github.com/FasterXML/jackson-databind/pull/6127

## Security

* #70: Fixed vulnerability CVE-2026-19032 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`
* #71: Fixed vulnerability CVE-2026-68497 in dependency `com.fasterxml.jackson.core:jackson-databind:jar:2.22.1:compile`

## Dependency Updates

### Compile Dependency Updates

* Updated `com.exasol:udf-api-java:1.0.10` to `1.0.11`
* Updated `com.fasterxml.jackson.core:jackson-databind:2.22.1` to `2.22.2`
* Updated `com.fasterxml.jackson.module:jackson-module-scala_2.13:2.22.1` to `2.22.2`
* Updated `org.apache.avro:avro:1.12.1` to `1.12.2`
* Updated `org.scala-lang:scala-library:2.13.18` to `3.8.4`
* Updated `org.slf4j:slf4j-simple:2.0.18` to `2.0.19`

### Plugin Dependency Updates

* Updated `com.diffplug.spotless:spotless-maven-plugin:3.8.0` to `3.10.2`
* Updated `com.exasol:error-code-crawler-maven-plugin:2.1.0` to `2.1.1`
* Updated `com.exasol:project-keeper-maven-plugin:5.7.4` to `5.7.5`
* Updated `io.github.git-commit-id:git-commit-id-maven-plugin:10.0.0` to `10.0.1`
* Updated `org.apache.maven.plugins:maven-toolchains-plugin:3.2.0` to `3.3.0`
* Updated `org.codehaus.mojo:flatten-maven-plugin:1.7.3` to `1.8.0`
* Updated `org.itsallcode:openfasttrace-maven-plugin:2.3.1` to `3.0.0`
