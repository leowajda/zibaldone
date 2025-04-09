package com.zibaldone.cats
package ch_03

trait `apply`[F[_]] extends ch_01.`functor`[F] with ch_03.`semigroupal`[F]:

  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
  
  override def product[A, B](fa: F[A], fb: F[B]): F[(A, B)] =
    val ff: F[A => (A, B)] = map(fb)(b => (a: A) => (a, b))
    ap(ff)(fa)

  // ex. implement mapN
  def mapN[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = map(product(fa, fb))(f(_, _))
