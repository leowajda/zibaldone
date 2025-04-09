package com.zibaldone.cats
package hierarchy

trait FlatMap[F[_]] extends Apply[F]:

  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  final override def ap[A, B](ff: F[A => B])(fa: F[A]): F[B] = flatMap(ff)(f => map(fa)(f(_)))
