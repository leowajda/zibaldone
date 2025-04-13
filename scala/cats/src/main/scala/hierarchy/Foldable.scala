package com.zibaldone.cats
package hierarchy

import cats.Eval

trait Foldable[F[_]]:

  def foldLeft[A, B](fa: F[A], b: B)(f: (B, A) => B): B
  def foldRight[A, B](fa: F[A], b: Eval[B])(f: (A, Eval[B]) => Eval[B]): Eval[B]
