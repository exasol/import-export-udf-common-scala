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
| [scala-logging][10]          | [Apache 2.0 License][11]                      |

## Test Dependencies

| Dependency                                 | License                                   |
| ------------------------------------------ | ----------------------------------------- |
| [scalatest][12]                            | [the Apache License, ASL Version 2.0][13] |
| [scalatestplus-mockito][14]                | [Apache-2.0][13]                          |
| [mockito-core][15]                         | [MIT][16]                                 |
| [EqualsVerifier \| release normal jar][17] | [Apache License, Version 2.0][7]          |
| [SLF4J Simple Provider][18]                | [MIT License][19]                         |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [SonarQube Scanner for Maven][20]                       | [GNU LGPL 3][21]                              |
| [Apache Maven Compiler Plugin][22]                      | [Apache-2.0][7]                               |
| [Apache Maven Enforcer Plugin][23]                      | [Apache-2.0][7]                               |
| [Maven Flatten Plugin][24]                              | [Apache Software Licenese][7]                 |
| [ScalaTest Maven Plugin][25]                            | [the Apache License, ASL Version 2.0][13]     |
| [OpenFastTrace Maven Plugin][26]                        | [GNU General Public License v3.0][27]         |
| [Project Keeper Maven plugin][28]                       | [The MIT License][29]                         |
| [Scalastyle Maven Plugin][30]                           | [Apache 2.0][11]                              |
| [spotless-maven-plugin][31]                             | [The Apache Software License, Version 2.0][7] |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][32] | [ASL2][33]                                    |
| [scala-maven-plugin][34]                                | [Public domain (Unlicense)][35]               |
| [Maven Surefire Plugin][36]                             | [Apache-2.0][7]                               |
| [Versions Maven Plugin][37]                             | [Apache License, Version 2.0][7]              |
| [duplicate-finder-maven-plugin Maven Mojo][38]          | [Apache License 2.0][11]                      |
| [Apache Maven Deploy Plugin][39]                        | [Apache-2.0][7]                               |
| [Apache Maven GPG Plugin][40]                           | [Apache-2.0][7]                               |
| [Apache Maven Source Plugin][41]                        | [Apache License, Version 2.0][7]              |
| [Apache Maven Javadoc Plugin][42]                       | [Apache-2.0][7]                               |
| [Nexus Staging Maven Plugin][43]                        | [Eclipse Public License][44]                  |
| [JaCoCo :: Maven Plugin][45]                            | [Eclipse Public License 2.0][46]              |
| [error-code-crawler-maven-plugin][47]                   | [MIT License][48]                             |
| [Reproducible Build Maven Plugin][49]                   | [Apache 2.0][33]                              |
| [scalafix-maven-plugin][50]                             | [BSD-3-Clause][51]                            |

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
[10]: https://github.com/lightbend/scala-logging
[11]: http://www.apache.org/licenses/LICENSE-2.0.html
[12]: http://www.scalatest.org
[13]: http://www.apache.org/licenses/LICENSE-2.0
[14]: https://github.com/scalatest/scalatestplus-mockito
[15]: https://github.com/mockito/mockito
[16]: https://opensource.org/licenses/MIT
[17]: https://www.jqno.nl/equalsverifier
[18]: http://www.slf4j.org
[19]: http://www.opensource.org/licenses/mit-license.php
[20]: http://sonarsource.github.io/sonar-scanner-maven/
[21]: http://www.gnu.org/licenses/lgpl.txt
[22]: https://maven.apache.org/plugins/maven-compiler-plugin/
[23]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[24]: https://www.mojohaus.org/flatten-maven-plugin/
[25]: https://www.scalatest.org/user_guide/using_the_scalatest_maven_plugin
[26]: https://github.com/itsallcode/openfasttrace-maven-plugin
[27]: https://www.gnu.org/licenses/gpl-3.0.html
[28]: https://github.com/exasol/project-keeper/
[29]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[30]: http://www.scalastyle.org
[31]: https://github.com/diffplug/spotless
[32]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[33]: http://www.apache.org/licenses/LICENSE-2.0.txt
[34]: http://github.com/davidB/scala-maven-plugin
[35]: http://unlicense.org/
[36]: https://maven.apache.org/surefire/maven-surefire-plugin/
[37]: https://www.mojohaus.org/versions/versions-maven-plugin/
[38]: https://basepom.github.io/duplicate-finder-maven-plugin
[39]: https://maven.apache.org/plugins/maven-deploy-plugin/
[40]: https://maven.apache.org/plugins/maven-gpg-plugin/
[41]: https://maven.apache.org/plugins/maven-source-plugin/
[42]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[43]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[44]: http://www.eclipse.org/legal/epl-v10.html
[45]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[46]: https://www.eclipse.org/legal/epl-2.0/
[47]: https://github.com/exasol/error-code-crawler-maven-plugin/
[48]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[49]: http://zlika.github.io/reproducible-build-maven-plugin
[50]: https://github.com/evis/scalafix-maven-plugin
[51]: https://opensource.org/licenses/BSD-3-Clause
