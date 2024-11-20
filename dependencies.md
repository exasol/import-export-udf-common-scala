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
| [SLF4J Simple Provider][10]  | [MIT License][11]                             |
| [scala-logging][12]          | [Apache 2.0 License][13]                      |

## Test Dependencies

| Dependency                                 | License                                   |
| ------------------------------------------ | ----------------------------------------- |
| [scalatest][14]                            | [the Apache License, ASL Version 2.0][15] |
| [scalatestplus-mockito][16]                | [Apache-2.0][15]                          |
| [mockito-core][17]                         | [MIT][18]                                 |
| [EqualsVerifier \| release normal jar][19] | [Apache License, Version 2.0][7]          |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [Apache Maven Clean Plugin][20]                         | [Apache-2.0][7]                               |
| [Apache Maven Install Plugin][21]                       | [Apache-2.0][7]                               |
| [Apache Maven Resources Plugin][22]                     | [Apache-2.0][7]                               |
| [Apache Maven Site Plugin][23]                          | [Apache License, Version 2.0][7]              |
| [SonarQube Scanner for Maven][24]                       | [GNU LGPL 3][25]                              |
| [Apache Maven Toolchains Plugin][26]                    | [Apache-2.0][7]                               |
| [Apache Maven Compiler Plugin][27]                      | [Apache-2.0][7]                               |
| [Apache Maven Enforcer Plugin][28]                      | [Apache-2.0][7]                               |
| [Maven Flatten Plugin][29]                              | [Apache Software Licenese][7]                 |
| [ScalaTest Maven Plugin][30]                            | [the Apache License, ASL Version 2.0][15]     |
| [OpenFastTrace Maven Plugin][31]                        | [GNU General Public License v3.0][32]         |
| [Project Keeper Maven plugin][33]                       | [The MIT License][34]                         |
| [Scalastyle Maven Plugin][35]                           | [Apache 2.0][13]                              |
| [spotless-maven-plugin][36]                             | [The Apache Software License, Version 2.0][7] |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][37] | [ASL2][38]                                    |
| [scala-maven-plugin][39]                                | [Public domain (Unlicense)][40]               |
| [Maven Surefire Plugin][41]                             | [Apache-2.0][7]                               |
| [Versions Maven Plugin][42]                             | [Apache License, Version 2.0][7]              |
| [duplicate-finder-maven-plugin Maven Mojo][43]          | [Apache License 2.0][13]                      |
| [Apache Maven Deploy Plugin][44]                        | [Apache-2.0][7]                               |
| [Apache Maven GPG Plugin][45]                           | [Apache-2.0][7]                               |
| [Apache Maven Source Plugin][46]                        | [Apache License, Version 2.0][7]              |
| [Apache Maven Javadoc Plugin][47]                       | [Apache-2.0][7]                               |
| [Nexus Staging Maven Plugin][48]                        | [Eclipse Public License][49]                  |
| [JaCoCo :: Maven Plugin][50]                            | [EPL-2.0][51]                                 |
| [Quality Summarizer Maven Plugin][52]                   | [MIT License][53]                             |
| [error-code-crawler-maven-plugin][54]                   | [MIT License][55]                             |
| [Reproducible Build Maven Plugin][56]                   | [Apache 2.0][38]                              |
| [scalafix-maven-plugin][57]                             | [BSD-3-Clause][58]                            |

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
[18]: https://opensource.org/licenses/MIT
[19]: https://www.jqno.nl/equalsverifier
[20]: https://maven.apache.org/plugins/maven-clean-plugin/
[21]: https://maven.apache.org/plugins/maven-install-plugin/
[22]: https://maven.apache.org/plugins/maven-resources-plugin/
[23]: https://maven.apache.org/plugins/maven-site-plugin/
[24]: http://sonarsource.github.io/sonar-scanner-maven/
[25]: http://www.gnu.org/licenses/lgpl.txt
[26]: https://maven.apache.org/plugins/maven-toolchains-plugin/
[27]: https://maven.apache.org/plugins/maven-compiler-plugin/
[28]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[29]: https://www.mojohaus.org/flatten-maven-plugin/
[30]: https://www.scalatest.org/user_guide/using_the_scalatest_maven_plugin
[31]: https://github.com/itsallcode/openfasttrace-maven-plugin
[32]: https://www.gnu.org/licenses/gpl-3.0.html
[33]: https://github.com/exasol/project-keeper/
[34]: https://github.com/exasol/project-keeper/blob/main/LICENSE
[35]: http://www.scalastyle.org
[36]: https://github.com/diffplug/spotless
[37]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[38]: http://www.apache.org/licenses/LICENSE-2.0.txt
[39]: http://github.com/davidB/scala-maven-plugin
[40]: http://unlicense.org/
[41]: https://maven.apache.org/surefire/maven-surefire-plugin/
[42]: https://www.mojohaus.org/versions/versions-maven-plugin/
[43]: https://basepom.github.io/duplicate-finder-maven-plugin
[44]: https://maven.apache.org/plugins/maven-deploy-plugin/
[45]: https://maven.apache.org/plugins/maven-gpg-plugin/
[46]: https://maven.apache.org/plugins/maven-source-plugin/
[47]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[48]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[49]: http://www.eclipse.org/legal/epl-v10.html
[50]: https://www.jacoco.org/jacoco/trunk/doc/maven.html
[51]: https://www.eclipse.org/legal/epl-2.0/
[52]: https://github.com/exasol/quality-summarizer-maven-plugin/
[53]: https://github.com/exasol/quality-summarizer-maven-plugin/blob/main/LICENSE
[54]: https://github.com/exasol/error-code-crawler-maven-plugin/
[55]: https://github.com/exasol/error-code-crawler-maven-plugin/blob/main/LICENSE
[56]: http://zlika.github.io/reproducible-build-maven-plugin
[57]: https://github.com/evis/scalafix-maven-plugin
[58]: https://opensource.org/licenses/BSD-3-Clause
