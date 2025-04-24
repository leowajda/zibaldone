package com.zibaldone.cats
package hierarchy

trait Functor[F[_]] extends Invariant[F]:

  def map[A, B](fa: F[A])(f: A => B): F[B]
  override def imap[A, B](fa: F[A])(forth: A => B)(back: B => A): F[B] = map(fa)(forth)
