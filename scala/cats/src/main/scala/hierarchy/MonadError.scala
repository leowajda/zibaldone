package com.zibaldone.cats
package hierarchy

trait MonadError[F[_], E] extends ApplicativeError[F, E] with Monad[F]:
  def ensure[A](fa: F[A])(e: => E)(f: E => Boolean): F[A]
