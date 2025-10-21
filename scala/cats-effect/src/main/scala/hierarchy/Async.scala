package hierarchy

import scala.concurrent.ExecutionContext

trait Async[F[_]] extends Sync[F] with Temporal[F]:

  def executionContext: F[ExecutionContext]
  def evalOn[A](fa: F[A], ec: ExecutionContext): F[A]
  def async[A](cb: (Either[Throwable, A] => Unit) => F[Option[F[Unit]]]): F[A]

  def async_[A](cb: (Either[Throwable, A] => Unit) => Unit): F[A] = async(kb => map(pure(cb(kb)))(_ => None))
  override def never[A]: F[A]                                     = async(_ => pure(Some(unit)))
