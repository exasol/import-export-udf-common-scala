package com.exasol.common.file

import java.io.File
import java.nio.file.Files

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class FileCheckerTest extends AnyFunSuite with Matchers {

  test("temporary file checker checks correct path") {
    val fileParent = "/tmp/bfsdefault/bucket1"
    val file = new File(fileParent, "/file.txt")
    Files.createDirectories(new File(fileParent).toPath())
    Files.createFile(file.toPath())
    assert(new TemporaryFileChecker().isRegularFile("/tmp/bfsdefault/bucket1/file.txt") === true)
    file.delete()
  }

  test("bucketfs file checker throws when path is missing") {
    assert(new BucketFSFileChecker().isRegularFile("/buckets/non-existing/default/file.txt") === false)
  }

  test("bucketfs file checker throws when path does not start with expected prefix") {
    val thrown = intercept[IllegalArgumentException] {
      new BucketFSFileChecker().isRegularFile("/var/log/bucket1/file.txt")
    }
    val message = thrown.getMessage()
    assert(message.startsWith("E-IEUCS-12"))
    assert(message.contains("Provided path '/var/log/bucket1/file.txt' does not start with expected"))
    assert(message.contains("Please make sure that file path start with '/buckets'."))
  }

  class TemporaryFileChecker extends FileChecker {
    override final def getLocationPrefix(): String = "/tmp"
  }

}
