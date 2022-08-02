# Import Export UDF Common Scala 0.4.2, released 2022-08-03

Code name: Fixed Maven Central deployment

## Summary

The automatic Maven Central deployment tried to upload both variants for Scala 2.12 and 2.13 to the same artifact https://repo1.maven.org/maven2/com/exasol/import-export-udf-common-scala/ which causes the build to fail.

Now they are uploaded with the correct artifact ids:

* https://repo1.maven.org/maven2/com/exasol/import-export-udf-common-scala_2.12/
* https://repo1.maven.org/maven2/com/exasol/import-export-udf-common-scala_2.13/


## Bugfix

* #36: Fixed Maven Central deployment

## Dependency Updates
