package com.zibaldone.cats
package ch_04

// contravariant type class
trait Format[T]:

  def format(value: T): String

  // functor applies transformations in order
  // contramap applies transformation in reverse order
  def contramap[A](f: A => T): Format[A] = (a: A) => format(f(a))

trait `contravariant`[F[_]] extends ch_04.`invariant`[F]:

  def contramap[A, B](fa: F[A])(f: B => A): F[B]
  override def imap[A, B](fa: F[A])(forth: A => B)(back: B => A): F[B] = contramap(fa)(back)
