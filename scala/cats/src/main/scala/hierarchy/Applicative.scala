package com.zibaldone.cats
package hierarchy

trait Applicative[F[_]] extends Semigroupal[F] with Functor[F]:
  def pure[A](a: A): F[A]
