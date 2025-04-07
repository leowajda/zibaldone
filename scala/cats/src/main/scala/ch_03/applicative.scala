package com.zibaldone.cats
package ch_03

// cats.data.Validated can't be a Monad, but it still qualifies as an Applicative
trait `applicative`[F[_]] extends ch_01.`functor`[F] with ch_03.`semigroupal`[F]:
  def pure[A](a: A): F[A]
  // can't override `product` here because I haven't defined applicative.ap

object `applicative`:

  extension [A](any: A)
    def lift[F[_]: `applicative` as applicative]: F[A] = applicative.pure(any)

import cats.Applicative

// ex. product in terms of applicative
def productWithApplicative[F[_]: Applicative as applicative, A, B](fa: F[A], fb: F[B]): F[(A, B)] =
  val ff: F[A => (A, B)] = applicative.map(fb)(b => (a: A) => (a, b))
  applicative.ap(ff)(fa) // def ap[F[_], A, B](ff: F[A => B])(fa: F[A]): F[B]
