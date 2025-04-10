package com.zibaldone.cats
package ch_03

// MonadError[Try, Throwable]
trait `monadError`[F[_], E] extends ch_03.`applicativeError`[F, E] with ch_01.`monad`[F]:
  def ensure[A](fa: F[A])(e: E)(f: E => Boolean): F[A]
