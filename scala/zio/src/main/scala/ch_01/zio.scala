package com.zibaldone.zio
package ch_01

final case class ZIO[-R, +E, +A](unsafeRun: R => Either[E, A]):

  def map[B](f: A => B): ZIO[R, E, B] = ZIO { r =>
    unsafeRun(r) match
      case Left(error)  => Left(error)
      case Right(value) => Right(f(value))
  }

  def flatMap[R1 <: R, E1 >: E, B](f: A => ZIO[R1, E1, B]): ZIO[R1, E1, B] = ZIO { r =>
    unsafeRun(r) match
      case Left(error)  => Left(error)
      case Right(value) => f(value).unsafeRun(r)
  }

object ZIO:

  // Succeed with an `A`, may fail with `E`, no requirements
  type IO[+E, +A]   = ZIO[Any, E, A]
  // Succeed with an `A`, may fail with `Throwable`, no requirements
  type Task[+A]     = ZIO[Any, Throwable, A]
  // Succeed with an `A`, may fail with `Throwable`, requires an `R`
  type RIO[-R, +A]  = ZIO[R, Throwable, A]
  // Succeed with an `A`, cannot fail, no requirements
  type UIO[+A]      = ZIO[Any, Nothing, A]
  // Succeed with an `A`, cannot fail, requires an `R`
  type URIO[-R, +A] = ZIO[R, Nothing, A]
