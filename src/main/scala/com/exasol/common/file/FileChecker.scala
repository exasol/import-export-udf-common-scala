package com.exasol.common.file

import java.io.File
import java.io.IOException
import java.io.UncheckedIOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.exasol.errorreporting.ExaError

/**
 * An abstract class for file checker implementations.
 */
abstract class FileChecker {

  /**
   * Returns an expected prefix that file paths starts with for this filesystem.
   *
   * @return a location prefix
   */
  def getLocationPrefix(): String

  /**
   * Cheks if path is regular file.
   *
   * @param path a path to file location
   * @return {@code true} if regular file, otherwise {@code false}
   */
  final def isRegularFile(filePath: String): Boolean = {
    val path = Paths.get(filePath)
    checkStartsWithPath(path.toFile())
    Files.isRegularFile(path)
  }

  protected[file] final def checkStartsWithPath(file: File): Unit =
    try {
      val absolutePath = file.getCanonicalPath()
      if (!absolutePath.startsWith(getLocationPrefix())) {
        throw new IllegalArgumentException(
          ExaError
            .messageBuilder("E-IEUCS-12")
            .message("Provided path {{PATH}} does not start with expected location prefix.", absolutePath)
            .mitigation("Please make sure that file path start with {{PREFIX}}.", getLocationPrefix())
            .toString()
        )
      }
    } catch {
      case exception: IOException =>
        throw new UncheckedIOException(
          ExaError
            .messageBuilder("E-IEUCS-13")
            .message("Failed to open path {{PATH}}.", file.getAbsolutePath())
            .mitigation("Please make sure that file exists and starts with location {{PREFIX}}", getLocationPrefix())
            .toString(),
          exception
        )
    }

}
