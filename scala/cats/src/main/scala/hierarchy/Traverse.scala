package com.zibaldone.cats
package hierarchy

trait Traverse[F[_]] extends Foldable[F] with Functor[F]:

  def traverse[M[_]: Applicative, A, B](fa: F[A])(f: A => M[B]): M[F[B]]
  def sequence[M[_]: Applicative, A](fa: F[M[A]]): M[F[A]] = traverse(fa)(identity)
