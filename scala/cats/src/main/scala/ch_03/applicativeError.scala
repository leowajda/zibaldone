package com.zibaldone.cats
package ch_03

trait `applicativeError`[F[_], E] extends ch_03.`applicative`[F]:

  def raiseError[A](e: E): F[A]
  def handleErrorWith[A](fa: F[A])(f: E => F[A]): F[A]
  def handleError[A](fa: F[A])(f: E => A): F[A] = handleErrorWith(fa)(e => pure(f(e)))
