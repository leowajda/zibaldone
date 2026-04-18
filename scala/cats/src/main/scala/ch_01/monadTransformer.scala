package com.zibaldone.cats
package ch_01

import cats.data.EitherT
import cats.instances.future.*
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

// ex. request spike
final case class AsyncService(bandwidths: Map[String, Int]):

  opaque type AsyncResponse[T] = EitherT[Future, String, T] // Future[Either[String, T]]

  private def bandwidth(server: String): AsyncResponse[Int] = bandwidths.get(server) match
    case None        => EitherT.left { Future.successful("absent") }
    case Some(value) => EitherT.right { Future.successful(value) }

  private def canWithstandSurge(a: String, b: String): AsyncResponse[Boolean] =
    for
      aBandwidth <- bandwidth(a)
      bBandwidth <- bandwidth(b)
    yield aBandwidth + bBandwidth > 250

  def report(a: String, b: String): AsyncResponse[String] = canWithstandSurge(a, b).transform {
    case Left(rootCause) => Left(rootCause)
    case Right(true)     => Right("enough bandwidth")
    case Right(false)    => Left("not enough bandwidth")
  }
