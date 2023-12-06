# Import Export UDF Common Scala 2.0.0, released 2023-12-06

Code name: Remove dependencies from JAR

## Summary

Previous releases of this project contained all dependencies in the published JAR file (i.e. fat JAR). This project is a library that is used in other projects and should not contain dependencies in the JAR, so we removed them.

## Bugfixes

* #54: Removed dependencies from published JAR

## Dependency Updates

### Plugin Dependency Updates

* Updated `com.exasol:project-keeper-maven-plugin:2.9.16` to `2.9.17`
* Removed `org.apache.maven.plugins:maven-assembly-plugin:3.5.0`
* Updated `org.codehaus.mojo:versions-maven-plugin:2.16.1` to `2.16.2`
