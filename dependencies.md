<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                   | License                                       |
| ---------------------------- | --------------------------------------------- |
| [Scala Library][0]           | [Apache-2.0][1]                               |
| [Exasol UDF API for Java][2] | [MIT License][3]                              |
| [error-reporting-java][4]    | [MIT License][5]                              |
| [Apache Avro][6]             | [Apache-2.0][7]                               |
| [jackson-databind][8]        | [The Apache Software License, Version 2.0][7] |
| [jackson-module-scala][9]    | [The Apache Software License, Version 2.0][7] |
| [SLF4J Simple Binding][10]   | [MIT License][11]                             |
| [scala-logging][12]          | [Apache 2.0 License][13]                      |

## Test Dependencies

| Dependency                                 | License                                   |
| ------------------------------------------ | ----------------------------------------- |
| [scalatest][14]                            | [the Apache License, ASL Version 2.0][15] |
| [scalatestplus-mockito][16]                | [Apache-2.0][15]                          |
| [mockito-core][17]                         | [The MIT License][18]                     |
| [EqualsVerifier \| release normal jar][19] | [Apache License, Version 2.0][7]          |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [SonarQube Scanner for Maven][20]                       | [GNU LGPL 3][21]                              |
| [Apache Maven Compiler Plugin][22]                      | [Apache-2.0][7]                               |
| [Apache Maven Enforcer Plugin][23]                      | [Apache-2.0][7]                               |
| [Maven Flatten Plugin][24]                              | [Apache Software Licenese][7]                 |
| [ScalaTest Maven Plugin][25]                            | [the Apache License, ASL Version 2.0][15]     |
| [Apache Maven Assembly Plugin][26]                      | [Apache License, Version 2.0][7]              |
| [OpenFastTrace Maven Plugin][27]                        | [GNU General Public License v3.0][28]         |
| [Project Keeper Maven plugin][29]                       | [The MIT License][30]                         |
| [Scalastyle Maven Plugin][31]                           | [Apache 2.0][13]                              |
| [spotless-maven-plugin][32]                             | [The Apache Software License, Version 2.0][7] |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][33] | [ASL2][34]                                    |
| [scala-maven-plugin][35]                                | [Public domain (Unlicense)][36]               |
| [Maven Surefire Plugin][37]                             | [Apache-2.0][7]                               |
| [Versions Maven Plugin][38]                             | [Apache License, Version 2.0][7]              |
| [duplicate-finder-maven-plugin Maven Mojo][39]          | [Apache License 2.0][13]                      |
| [Apache Maven Deploy Plugin][40]                        | [Apache-2.0][7]                               |
| [Apache Maven GPG Plugin][41]                           | [Apache-2.0][7]                               |
| [Apache Maven Source Plugin][42]                        | [Apache License, Version 2.0][7]              |
| [Apache Maven Javadoc Plugin][43]                       | [Apache-2.0][7]                               |
| [Nexus Staging Maven Plugin][44]                        | [Eclipse Public License][45]                  |
| [JaCoCo :: Maven Plugin][46]                            | [Eclipse Public License 2.0][47]              |
| [error-code-crawler-maven-plugin][48]                   | [MIT License][49]                             |
| [Reproducible Build Maven Plugin][50]                   | [Apache 2.0][34]                              |
| [scalafix-maven-plugin][51]                             | [BSD-3-Clause][52]                            |

[0]: https://www.scala-lang.org/
[1]: https://www.apache.org/licenses/LICENSE-2.0
[2]: https://github.com/exasol/udf-api-java/
[3]: https://github.com/exasol/udf-api-java/blob/main/LICENSE
[4]: https://github.com/exasol/error-reporting-java/
[5]: https://github.com/exasol/error-reporting-java/blob/main/LICENSE
[6]: https://avro.apache.org
[7]: https://www.apache.org/licenses/LICENSE-2.0.txt
[8]: https://github.com/FasterXML/jackson
[9]: https://github.com/FasterXML/jackson-module-scala
[10]: http://www.slf4j.org
[11]: http://www.opensource.org/licenses/mit-license.php
[12]: https://github.com/lightbend/scala-logging
[13]: http://www.apache.org/licenses/LICENSE-2.0.html
[14]: http://www.scalatest.org
[15]: http://www.apache.org/licenses/LICENSE-2.0
[16]: https://github.com/scalatest/scalatestplus-mockito
[17]: https://github.com/mockito/mockito
[18]: https://github.com/mockito/mockito/blob/main/LICENSE
[19]: https://www.jqno.nl/equalsverifier
[20]: http://sonarsource.github.io/sonar-scanner-maven/
[21]: http://www.gnu.org/licenses/lgpl.txt
[22]: https://maven.apache.org/plugins/maven-compiler-plugin/
[23]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[24]: https://www.mojohaus.org/flatten-maven-plugin/
[25]: https://www.scalatest.org/user_guide/using_the_scalatest_maven_plugin
[26]: https://maven.apache.org/plugins/maven-assembly-plugin/
[27]: https://github.com/itsallcode/openfasttrace-maven-plugin
[28]: https://www.gnu.org/licenses/gpl-3.0.html
[29]: https://github.com/exasol/project-keeper/
[30]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[31]: http://www.scalastyle.org
[32]: https://github.com/diffplug/spotless
[33]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[34]: http://www.apache.org/licenses/LICENSE-2.0.txt
[35]: http://github.com/davidB/scala-maven-plugin
[36]: http://unlicense.org/
[37]: https://maven.apache.org/surefire/maven-surefire-plugin/
[38]: https://www.mojohaus.org/versions/versions-maven-plugin/
[39]: https://basepom.github.io/duplicate-finder-maven-plugin
[40]: https://maven.apache.org/plugins/maven-deploy-plugin/
[41]: https://maven.apache.org/plugins/maven-gpg-plugin/
[42]: https://maven.apache.org/plugins/maven-source-plugin/
[43]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[44]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[45]: http://www.eclipse.org/legal/epl-v10.html
[46]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[47]: https://www.eclipse.org/legal/epl-2.0/
[48]: https://github.com/exasol/error-code-crawler-maven-plugin/
[49]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[50]: http://zlika.github.io/reproducible-build-maven-plugin
[51]: https://github.com/evis/scalafix-maven-plugin
[52]: https://opensource.org/licenses/BSD-3-Clause
