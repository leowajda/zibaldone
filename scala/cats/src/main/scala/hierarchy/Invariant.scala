package com.zibaldone.cats
package hierarchy

trait Invariant[F[_]]:
  def imap[A, B](fa: F[A])(forth: A => B)(back: B => A): F[B]
