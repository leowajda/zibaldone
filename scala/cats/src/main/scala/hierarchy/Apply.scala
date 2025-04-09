package com.zibaldone.cats
package hierarchy

trait Apply[F[_]] extends Functor[F] with Semigroupal[F]:
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
