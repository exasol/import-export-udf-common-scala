package com.exasol.common.file

/**
 * A BucketFS file location checker implementation.
 */
class BucketFSFileChecker extends FileChecker {

  override final def getLocationPrefix(): String = "/buckets"

}
