package com.zibaldone.cats
package hierarchy

trait Apply[F[_]] extends Functor[F] with Semigroupal[F]:

  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]

  override def product[A, B](fa: F[A], fb: F[B]): F[(A, B)] =
    val ff: F[A => (A, B)] = map(fb)(b => (a: A) => (a, b))
    ap(ff)(fa)
