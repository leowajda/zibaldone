package ch_02

import cats.effect.*
import java.util.Scanner

object resources:

  // ex. refactor ch_02.brackets.fileReader
  def fileReader(path: String): IO[Unit] =
    Resource.make(ch_02.brackets.fileScanner(path))(scanner => IO(scanner.close())).use(ch_02.brackets.scannerReader)

  // ex. refactor ch_02.brackets.connectionFromConfig
  // resources compose, brackets do not
  def connectionFromConfig(path: String): IO[Unit] =
    val connection =
      for
        scanner <- Resource.make(ch_02.brackets.fileScanner(path))(scanner => IO(scanner.close()))
        conn    <- Resource.make(IO.pure(Connection(scanner.nextLine)))(_.close)
      yield conn

    connection.use(_.open)
