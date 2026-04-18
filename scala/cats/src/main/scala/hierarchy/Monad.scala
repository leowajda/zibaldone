package com.zibaldone.cats
package hierarchy

trait Monad[F[_]] extends Applicative[F] with FlatMap[F]:

  override def map[A, B](fa: F[A])(f: A => B): F[B]         = flatMap(fa)(a => pure(f(a)))
  override def product[A, B](fa: F[A], fb: F[B]): F[(A, B)] = flatMap(fa)(a => map(fb)(b => (a, b)))
