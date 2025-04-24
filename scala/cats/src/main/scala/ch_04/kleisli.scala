package com.zibaldone.cats
package ch_04

final case class `kleisli`[F[_], A, B](run: A => F[B])

import cats.data.Kleisli

// ex. kleisli Id
// type Reader[-A, B] = ReaderT[Id, A, B]
// type ReaderT[F[_], -A, B] = Kleisli[F, A, B]
type IdKleisli[A, B] = Kleisli[cats.Id, A, B]