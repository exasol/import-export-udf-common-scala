<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                      | License                                       |
| ------------------------------- | --------------------------------------------- |
| [scala-library-bootstrapped][0] | [Apache-2.0][1]                               |
| [Exasol UDF API for Java][2]    | [MIT License][3]                              |
| [error-reporting-java][4]       | [MIT License][5]                              |
| [Apache Avro][6]                | [Apache-2.0][7]                               |
| [jackson-databind][8]           | [The Apache Software License, Version 2.0][7] |
| [jackson-module-scala][9]       | [The Apache Software License, Version 2.0][7] |
| [SLF4J Simple Provider][10]     | [MIT][11]                                     |
| [scala-logging][12]             | [Apache 2.0 License][13]                      |

## Test Dependencies

| Dependency                                 | License                                   |
| ------------------------------------------ | ----------------------------------------- |
| [scalatest][14]                            | [the Apache License, ASL Version 2.0][15] |
| [scalatestplus-mockito][16]                | [Apache-2.0][15]                          |
| [mockito-core][17]                         | [MIT][18]                                 |
| [EqualsVerifier \| release normal jar][19] | [Apache License, Version 2.0][7]          |

## Plugin Dependencies

| Dependency                                              | License                                        |
| ------------------------------------------------------- | ---------------------------------------------- |
| [SonarQube Scanner for Maven][20]                       | [GNU LGPL 3][21]                               |
| [Apache Maven Toolchains Plugin][22]                    | [Apache-2.0][7]                                |
| [Apache Maven Compiler Plugin][23]                      | [Apache-2.0][7]                                |
| [Apache Maven Enforcer Plugin][24]                      | [Apache-2.0][7]                                |
| [Maven Flatten Plugin][25]                              | [Apache Software License][7]                   |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][26] | [ASL2][27]                                     |
| [scala-maven-plugin][28]                                | [Public domain (Unlicense)][29]                |
| [Maven Surefire Plugin][30]                             | [Apache-2.0][7]                                |
| [Versions Maven Plugin][31]                             | [Apache License, Version 2.0][7]               |
| [duplicate-finder-maven-plugin Maven Mojo][32]          | [Apache License 2.0][13]                       |
| [Apache Maven Artifact Plugin][33]                      | [Apache-2.0][7]                                |
| [Apache Maven Deploy Plugin][34]                        | [Apache-2.0][7]                                |
| [Apache Maven Source Plugin][35]                        | [Apache-2.0][7]                                |
| [Apache Maven Javadoc Plugin][36]                       | [Apache-2.0][7]                                |
| [spdx-maven-plugin Maven Plugin][37]                    | [The Apache Software License, Version 2.0][27] |
| [Build Helper Maven Plugin][38]                         | [The MIT License][39]                          |
| [Apache Maven GPG Plugin][40]                           | [Apache-2.0][7]                                |
| [Central Publishing Maven Plugin][41]                   | [The Apache License, Version 2.0][7]           |
| [JaCoCo :: Maven Plugin][42]                            | [EPL-2.0][43]                                  |
| [error-code-crawler-maven-plugin][44]                   | [MIT License][45]                              |
| [Git Commit Id Maven Plugin][46]                        | [GNU Lesser General Public License 3.0][47]    |
| [ScalaTest Maven Plugin][48]                            | [the Apache License, ASL Version 2.0][15]      |
| [OpenFastTrace Maven Plugin][49]                        | [GNU General Public License v3.0][50]          |
| [Project Keeper Maven plugin][51]                       | [The MIT License][52]                          |
| [Scalastyle Maven Plugin][53]                           | [Apache 2.0][13]                               |
| [spotless-maven-plugin][54]                             | [The Apache Software License, Version 2.0][7]  |
| [scalafix-maven-plugin][55]                             | [BSD-3-Clause][56]                             |
| [Apache Maven Clean Plugin][57]                         | [Apache-2.0][7]                                |
| [Apache Maven Resources Plugin][58]                     | [Apache-2.0][7]                                |
| [Apache Maven Install Plugin][59]                       | [Apache-2.0][7]                                |
| [Apache Maven Site Plugin][60]                          | [Apache-2.0][7]                                |

[0]: https://scala-lang.org/
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
[11]: https://opensource.org/license/mit
[12]: https://github.com/lightbend/scala-logging
[13]: http://www.apache.org/licenses/LICENSE-2.0.html
[14]: http://www.scalatest.org
[15]: http://www.apache.org/licenses/LICENSE-2.0
[16]: https://github.com/scalatest/scalatestplus-mockito
[17]: https://github.com/mockito/mockito
[18]: https://opensource.org/licenses/MIT
[19]: https://www.jqno.nl/equalsverifier
[20]: https://docs.sonarsource.com/sonarqube-server/latest/extension-guide/developing-a-plugin/plugin-basics/sonar-scanner-maven/sonar-maven-plugin/
[21]: http://www.gnu.org/licenses/lgpl.txt
[22]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[23]: https://maven.apache.org/plugins/maven-compiler-plugin/
[24]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[25]: https://www.mojohaus.org/flatten-maven-plugin/
[26]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[27]: http://www.apache.org/licenses/LICENSE-2.0.txt
[28]: https://github.com/davidB/scala-maven-plugin
[29]: https://unlicense.org/
[30]: https://maven.apache.org/surefire/maven-surefire-plugin/
[31]: https://www.mojohaus.org/versions/versions-maven-plugin/
[32]: https://basepom.github.io/duplicate-finder-maven-plugin
[33]: https://maven.apache.org/plugins/maven-artifact-plugin/
[34]: https://maven.apache.org/plugins/maven-deploy-plugin/
[35]: https://maven.apache.org/plugins/maven-source-plugin/
[36]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[37]: https://github.com/spdx/spdx-maven-plugin
[38]: https://www.mojohaus.org/build-helper-maven-plugin/
[39]: https://spdx.org/licenses/MIT.txt
[40]: https://maven.apache.org/plugins/maven-gpg-plugin/
[41]: https://central.sonatype.org
[42]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[43]: https://www.eclipse.org/legal/epl-2.0/
[44]: https://github.com/exasol/error-code-crawler-maven-plugin/
[45]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[46]: https://github.com/git-commit-id/git-commit-id-maven-plugin
[47]: http://www.gnu.org/licenses/lgpl-3.0.txt
[48]: https://www.scalatest.org/user_guide/using_the_scalatest_maven_plugin
[49]: https://github.com/itsallcode/openfasttrace-maven-plugin
[50]: https://www.gnu.org/licenses/gpl-3.0.html
[51]: https://github.com/exasol/project-keeper/
[52]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[53]: http://www.scalastyle.org
[54]: https://github.com/diffplug/spotless
[55]: https://github.com/evis/scalafix-maven-plugin
[56]: https://opensource.org/licenses/BSD-3-Clause
[57]: https://maven.apache.org/plugins/maven-clean-plugin/
[58]: https://maven.apache.org/plugins/maven-resources-plugin/
[59]: https://maven.apache.org/plugins/maven-install-plugin/
[60]: https://maven.apache.org/plugins/maven-site-plugin/
