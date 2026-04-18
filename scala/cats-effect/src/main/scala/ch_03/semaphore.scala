package ch_03

import cats.effect.*
import cats.effect.std.Semaphore
import utils.*

import cats.syntax.parallel.*
import scala.concurrent.duration.*

val serverLogic: IO[Unit] = IO.sleep(2.seconds)

def serverLogic(id: Int, sem: Semaphore[IO]): IO[Unit] =
  for
    _ <- IO.pure(s"[session-$id] - waiting to run..").inspect
    _ <- sem.acquire
    _ <- IO.pure(s"[session-$id] - logged in").inspect
    _ <- serverLogic
    _ <- sem.release
    _ <- IO.pure(s"[session-$id] - logged out").inspect
  yield ()

def cappedServer(capSize: Int = 1 /* mutex */, numSessions: Int): IO[Unit] =
  for
    sem <- Semaphore[IO](capSize)
    _   <- (1 to numSessions).toList.parTraverse(serverLogic(_, sem))
  yield ()
