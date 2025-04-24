package com.zibaldone.cats
package hierarchy

trait Contravariant[F[_]] extends Invariant[F]:

  def contramap[A, B](fa: F[A])(f: B => A): F[B]
  override def imap[A, B](fa: F[A])(forth: A => B)(back: B => A): F[B] = contramap(fa)(back)
