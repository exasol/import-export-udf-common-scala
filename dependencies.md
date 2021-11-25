<!-- @formatter:off -->
# Dependencies

## Compile Dependencies

| Dependency                             | License                                       |
| -------------------------------------- | --------------------------------------------- |
| [Scala Library][0]                     | [Apache-2.0][1]                               |
| [Java Interface for EXASOL Scripts][2] | [MIT License][3]                              |
| [error-reporting-java][4]              | [MIT][5]                                      |
| [Apache Avro][6]                       | [Apache License, Version 2.0][7]              |
| [jackson-databind][8]                  | [The Apache Software License, Version 2.0][9] |
| [jackson-module-scala][10]             | [The Apache Software License, Version 2.0][7] |
| [SLF4J Simple Binding][12]             | [MIT License][13]                             |
| [scala-logging][14]                    | [Apache 2.0 License][15]                      |

## Test Dependencies

| Dependency                  | License                                   |
| --------------------------- | ----------------------------------------- |
| [scalatest][16]             | [the Apache License, ASL Version 2.0][17] |
| [scalatestplus-mockito][18] | [Apache-2.0][17]                          |
| [mockito-core][20]          | [The MIT License][21]                     |

## Plugin Dependencies

| Dependency                                              | License                                       |
| ------------------------------------------------------- | --------------------------------------------- |
| [scala-maven-plugin][22]                                | [Public domain (Unlicense)][23]               |
| [Apache Maven Compiler Plugin][24]                      | [Apache License, Version 2.0][7]              |
| [Maven Surefire Plugin][26]                             | [Apache License, Version 2.0][7]              |
| [ScalaTest Maven Plugin][28]                            | [the Apache License, ASL Version 2.0][17]     |
| [Apache Maven Assembly Plugin][30]                      | [Apache License, Version 2.0][7]              |
| [Versions Maven Plugin][32]                             | [Apache License, Version 2.0][7]              |
| [org.sonatype.ossindex.maven:ossindex-maven-plugin][34] | [ASL2][9]                                     |
| [Apache Maven Enforcer Plugin][36]                      | [Apache License, Version 2.0][7]              |
| [OpenFastTrace Maven Plugin][38]                        | [GNU General Public License v3.0][39]         |
| [Maven Failsafe Plugin][40]                             | [Apache License, Version 2.0][7]              |
| [Apache Maven GPG Plugin][42]                           | [Apache License, Version 2.0][7]              |
| [Apache Maven Deploy Plugin][44]                        | [Apache License, Version 2.0][7]              |
| [Nexus Staging Maven Plugin][46]                        | [Eclipse Public License][47]                  |
| [Apache Maven Source Plugin][48]                        | [Apache License, Version 2.0][7]              |
| [Apache Maven Javadoc Plugin][50]                       | [Apache License, Version 2.0][7]              |
| [Reproducible Build Maven Plugin][52]                   | [Apache 2.0][9]                               |
| [error-code-crawler-maven-plugin][54]                   | [MIT][5]                                      |
| [Project keeper maven plugin][56]                       | [MIT][5]                                      |
| [SCoverage Maven Plugin][58]                            | [The Apache Software License, Version 2.0][9] |
| [Scalastyle Maven Plugin][60]                           | [Apache 2.0][15]                              |
| [spotless-maven-plugin][62]                             | [The Apache Software License, Version 2.0][7] |
| [scalafix-maven-plugin][64]                             | [BSD-3-Clause][65]                            |
| [Apache Maven Clean Plugin][66]                         | [Apache License, Version 2.0][7]              |
| [Apache Maven Resources Plugin][68]                     | [Apache License, Version 2.0][7]              |
| [Apache Maven JAR Plugin][70]                           | [Apache License, Version 2.0][7]              |
| [Apache Maven Install Plugin][72]                       | [Apache License, Version 2.0][9]              |
| [Apache Maven Site Plugin][74]                          | [Apache License, Version 2.0][7]              |

[56]: https://github.com/exasol/project-keeper-maven-plugin
[58]: https://scoverage.github.io/scoverage-maven-plugin/1.4.1/
[18]: https://github.com/scalatest/scalatestplus-mockito
[4]: https://github.com/exasol/error-reporting-java
[10]: http://wiki.fasterxml.com/JacksonModuleScala
[9]: http://www.apache.org/licenses/LICENSE-2.0.txt
[60]: http://www.scalastyle.org
[26]: https://maven.apache.org/surefire/maven-surefire-plugin/
[62]: https://github.com/diffplug/spotless
[5]: https://opensource.org/licenses/MIT
[20]: https://github.com/mockito/mockito
[32]: http://www.mojohaus.org/versions-maven-plugin/
[24]: https://maven.apache.org/plugins/maven-compiler-plugin/
[68]: https://maven.apache.org/plugins/maven-resources-plugin/
[38]: https://github.com/itsallcode/openfasttrace-maven-plugin
[66]: https://maven.apache.org/plugins/maven-clean-plugin/
[8]: http://github.com/FasterXML/jackson
[44]: https://maven.apache.org/plugins/maven-deploy-plugin/
[23]: http://unlicense.org/
[1]: https://www.apache.org/licenses/LICENSE-2.0
[28]: https://www.scalatest.org/user_guide/using_the_scalatest_maven_plugin
[21]: https://github.com/mockito/mockito/blob/main/LICENSE
[52]: http://zlika.github.io/reproducible-build-maven-plugin
[13]: http://www.opensource.org/licenses/mit-license.php
[65]: https://opensource.org/licenses/BSD-3-Clause
[6]: https://avro.apache.org
[14]: https://github.com/lightbend/scala-logging
[48]: https://maven.apache.org/plugins/maven-source-plugin/
[3]: LICENSE-exasol-script-api.txt
[12]: http://www.slf4j.org
[64]: https://github.com/evis/scalafix-maven-plugin
[70]: https://maven.apache.org/plugins/maven-jar-plugin/
[17]: http://www.apache.org/licenses/LICENSE-2.0
[46]: http://www.sonatype.com/public-parent/nexus-maven-plugins/nexus-staging/nexus-staging-maven-plugin/
[15]: http://www.apache.org/licenses/LICENSE-2.0.html
[16]: http://www.scalatest.org
[40]: https://maven.apache.org/surefire/maven-failsafe-plugin/
[0]: https://www.scala-lang.org/
[47]: http://www.eclipse.org/legal/epl-v10.html
[74]: https://maven.apache.org/plugins/maven-site-plugin/
[39]: https://www.gnu.org/licenses/gpl-3.0.html
[7]: https://www.apache.org/licenses/LICENSE-2.0.txt
[36]: https://maven.apache.org/enforcer/maven-enforcer-plugin/
[2]: http://www.exasol.com
[72]: http://maven.apache.org/plugins/maven-install-plugin/
[34]: https://sonatype.github.io/ossindex-maven/maven-plugin/
[42]: https://maven.apache.org/plugins/maven-gpg-plugin/
[22]: http://github.com/davidB/scala-maven-plugin
[50]: https://maven.apache.org/plugins/maven-javadoc-plugin/
[54]: https://github.com/exasol/error-code-crawler-maven-plugin
[30]: https://maven.apache.org/plugins/maven-assembly-plugin/
