# Import Export UDF Common Scala 0.2.0, released 2020-10-30

## Features

* #9: Added SLF4J Logging Library as Common Dependency (PR #10)
* #11: Added Support for Avro Complex Types (Array, Map, Record) (PR #12)
* #13: Added Support for Avro Logical Types (BigDecimal, Date, Timestamp) (PR #14)

## Documentation

* #7: Added developer guide (PR #8)

## Dependency Updates

### Runtime Dependency Updates

* Updated `sbt.version` from `1.3.13` to `1.4.1`.
* Added `com.fasterxml.jackson.module:jackson-module-scala` version `2.11.3`.
* Updated `com.fasterxml.jackson.core:jackson-databind` from `2.11.2` to `2.11.3`.

### Test Dependency Updates

* Updated `org.mockito:mockito-core` from `3.5.10` to `3.6.0`.

### Plugin Updates

* Updated `com.github.cb372:sbt-explicit-dependencies` from `0.2.13` to `0.2.15`.
* Updated `org.wartremover:sbt-wartremover` from `2.4.10` to `2.4.12`.
* Updated `org.wartremover:sbt-wartremover-contib` from `1.3.8` to `1.3.10`.
