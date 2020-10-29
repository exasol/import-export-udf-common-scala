# Import Export UDF Common Scala

[![Build Status][travis-badge]][travis-link]
[![Coveralls][coveralls-badge]][coveralls-link]
[![Maven Central][maven-badge]][maven-link]

Common libraries for Exasol IMPORT and EXPORT user defined functions in Scala
programming language.

## Features

- Supports user provided key value parameters parsing
- Supports Avro record deserialization into internal data structure

## Information for Users

- [Changelog](doc/changes/changelog.md)

## Information for Contributors

* [Developer Guide](doc/development/developer_guide.md)

## Dependencies

### Runtime Dependencies

| Dependency                                  | Purpose                                                         | License            |
|---------------------------------------------|-----------------------------------------------------------------|--------------------|
| [Exasol Script API][exasol-script-api-link] | Accessing Exasol IMPORT / EXPORT API                            | MIT License        |
| [Apache Avro][apache-avro-link]             | Integration support for Avro format                             | Apache License 2.0 |
| [Scala Logging Library][scala-logging-link] | Scala logging library wrapping SLF4J                            | Apache License 2.0 |

### Test Dependencies

| Dependency                                  | Purpose                                                         | License            |
|---------------------------------------------|-----------------------------------------------------------------|--------------------|
| [Scalatest][scalatest-link]                 | Testing tool for Scala and Java developers                      | Apache License 2.0 |
| [Scalatest Plus][scalatestplus-link]        | Integration support between Scalatest and Mockito               | Apache License 2.0 |
| [Mockito Core][mockitocore-link]            | Mocking framework for unit tests                                | MIT License        |

### Compiler Plugin Dependencies

These plugins help with project development.

| Plugin Name                                 | Purpose                                                         | License              |
|---------------------------------------------|-----------------------------------------------------------------|----------------------|
| [SBT Coursier][sbt-coursier-link]           | Pure Scala artifact fetching                                    | Apache License 2.0   |
| [SBT Wartremover][sbt-wartremover-link]     | Flexible Scala code linting tool                                | Apache License 2.0   |
| [SBT Wartremover Contrib][sbt-wcontrib-link]| Community managed additional warts for wartremover              | Apache License 2.0   |
| [SBT Assembly][sbt-assembly-link]           | Create fat jars with all project dependencies                   | MIT License          |
| [SBT API Mappings][sbt-apimapping-link]     | A plugin that fetches API mappings for common Scala libraries   | Apache License 2.0   |
| [SBT Scoverage][sbt-scoverage-link]         | Integrates the scoverage code coverage library                  | Apache License 2.0   |
| [SBT Coveralls][sbt-coveralls-link]         | Uploads scala code coverage results to https://coveralls.io     | Apache License 2.0   |
| [SBT Updates][sbt-updates-link]             | Checks Maven and Ivy repositories for dependency updates        | BSD 3-Clause License |
| [SBT Scalafmt][sbt-scalafmt-link]           | A plugin for https://scalameta.org/scalafmt/ formatting         | Apache License 2.0   |
| [SBT Scalastyle][sbt-style-link]            | A plugin for http://www.scalastyle.org/ Scala style checker     | Apache License 2.0   |
| [SBT Dependency Graph][sbt-depgraph-link]   | A plugin for visualizing dependency graph of your project       | Apache License 2.0   |
| [SBT Explicit Dependencies][sbt-expdep-link]| Checks which direct libraries required to compile your code     | Apache License 2.0   |
| [SBT Sonatype][sbt-sonatype-link]           | Sbt plugin for publishing Scala projects to the Maven central   | Apache License 2.0   |
| [SBT PGP][sbt-pgp-link]                     | PGP plugin for `sbt`                                            | BSD 3-Clause License |
| [SBT Git][sbt-git-link]                     | A plugin for Git integration, used to version the release jars  | BSD 2-Clause License |

[travis-badge]: https://img.shields.io/travis/com/exasol/import-export-udf-common-scala/master.svg?logo=travis
[travis-link]: https://travis-ci.com/exasol/import-export-udf-common-scala
[coveralls-badge]: https://coveralls.io/repos/github/exasol/import-export-udf-common-scala/badge.svg?branch=master
[coveralls-link]: https://coveralls.io/github/exasol/import-export-udf-common-scala?branch=master
[maven-badge]: https://maven-badges.herokuapp.com/maven-central/com.exasol/import-export-udf-common-scala_2.12/badge.svg
[maven-link]: https://mvnrepository.com/artifact/com.exasol/import-export-udf-common-scala
[apache-avro-link]: https://avro.apache.org/
[scala-logging-link]: https://github.com/lightbend/scala-logging
[exasol-script-api-link]: https://docs.exasol.com/database_concepts/udf_scripts.htm
[scalatest-link]: http://www.scalatest.org/
[scalatestplus-link]: https://github.com/scalatest/scalatestplus-mockito
[mockitocore-link]: https://site.mockito.org/
[sbt-coursier-link]: https://github.com/coursier/coursier
[sbt-wartremover-link]: http://github.com/puffnfresh/wartremover
[sbt-wcontrib-link]: http://github.com/wartremover/wartremover-contrib
[sbt-assembly-link]: https://github.com/sbt/sbt-assembly
[sbt-apimapping-link]: https://github.com/ThoughtWorksInc/sbt-api-mappings
[sbt-scoverage-link]: http://github.com/scoverage/sbt-scoverage
[sbt-coveralls-link]: https://github.com/scoverage/sbt-coveralls
[sbt-updates-link]: http://github.com/rtimush/sbt-updates
[sbt-scalafmt-link]: https://github.com/lucidsoftware/neo-sbt-scalafmt
[sbt-style-link]: https://github.com/scalastyle/scalastyle-sbt-plugin
[sbt-depgraph-link]: https://github.com/jrudolph/sbt-dependency-graph
[sbt-sonatype-link]: https://github.com/xerial/sbt-sonatype
[sbt-pgp-link]: https://github.com/xerial/sbt-sonatype
[sbt-git-link]: https://github.com/sbt/sbt-git
[sbt-expdep-link]: https://github.com/cb372/sbt-explicit-dependencies
