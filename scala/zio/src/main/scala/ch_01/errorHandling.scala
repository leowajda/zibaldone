package com.zibaldone.zio
package ch_01

import zio.*

import java.io.IOException

/*
  ZIO[R, E, A].eval(Runtime) match
    case Success(a: A)
    case Cause.Fail(error: E)
    case Cause.Die(t: Throwable)
    case ....
 */

def cannotFail[A](a: => A): UIO[A] = ZIO.succeed(a)
def mightFail[A](a: => A): Task[A] = ZIO.attempt(a)
def failed[A](a: => A): Task[A]    = ZIO.fail(new RuntimeException)

// ex. turn errors into defects
def suppressAllErrors[A](task: Task[A]): UIO[A]              = task.orDie
def suppressSomeErrors[A](task: Task[A]): IO[IOException, A] = task.refineOrDie { case e: IOException => e }

// ex. turn defects into errors
def resurfaceAllErrors[A](zio: UIO[A]): Task[A]                  = zio.unrefineTo
def resurfaceSomeErrors[A](zio: UIO[A]): IO[RuntimeException, A] = zio.unrefine { case e: RuntimeException => e }

// ex. combine error channels
def combine[R, E1, E2, A, B](aZIO: ZIO[R, E1, A], bZIO: ZIO[R, E2, B]): ZIO[R, E1 | E2, (A, B)] =
  for
    a <- aZIO
    b <- bZIO
  yield (a, b)

// ex. left
def left[R, E, A, B](zio: ZIO[R, E, Either[A, B]]): ZIO[R, Either[E, A], B]                     = zio.foldZIO(
  failure = e => ZIO.fail(Left(e)),
  success =
    case Left(e)  => ZIO.fail(Right(e))
    case Right(b) => ZIO.succeed(b)
)

// ex. some
def some[R, E, A](zio: ZIO[R, E, Option[A]]): ZIO[R, Option[E], A]                              = zio.foldZIO(
  failure = e => ZIO.fail(Some(e)),
  success =
    case Some(a) => ZIO.succeed(a)
    case None    => ZIO.fail(None)
)
