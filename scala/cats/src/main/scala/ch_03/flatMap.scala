package com.zibaldone.cats
package ch_03

trait `flatMap`[F[_]] extends `apply`[F]:

  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  final override def ap[A, B](ff: F[A => B])(fa: F[A]): F[B] = flatMap(ff)(f => map(fa)(f(_)))
