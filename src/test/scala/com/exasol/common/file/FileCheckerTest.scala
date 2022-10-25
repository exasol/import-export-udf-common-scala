package com.exasol.common.file

import java.io.File
import java.io.IOException
import java.io.UncheckedIOException
import java.nio.file.Files

import org.mockito.Mockito.when
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar

class FileCheckerTest extends AnyFunSuite with Matchers with MockitoSugar {

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
    val path = "/var/log/bucket1/file.txt"
    val thrown = intercept[IllegalArgumentException] {
      new BucketFSFileChecker().isRegularFile(path)
    }
    val expectedPath = new File(path).getCanonicalPath()
    val message = thrown.getMessage()
    assert(message.startsWith("E-IEUCS-12"))
    assert(message.contains("Provided path '" + expectedPath + "' does not start with expected"))
    assert(message.contains("Please make sure that file path start with '/buckets'."))
  }

  test("bucketfs file checker throws ioexception") {
    val file = mock[File]
    when(file.getAbsolutePath()).thenReturn("test/path")
    when(file.getCanonicalPath()).thenThrow(new IOException())
    val thrown = intercept[UncheckedIOException] {
      new BucketFSFileChecker().checkStartsWithPath(file)
    }
    assert(thrown.getMessage().startsWith("E-IEUCS-13: Failed to open path 'test/path'."))
  }

  class TemporaryFileChecker extends FileChecker {
    override final def getLocationPrefix(): String = "/tmp"
  }

}
