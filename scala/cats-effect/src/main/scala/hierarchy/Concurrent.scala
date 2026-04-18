package hierarchy

import cats.effect.kernel.{Deferred, Ref}

trait Concurrent[F[_]] extends GenConcurrent[F, Throwable]

trait GenConcurrent[F[_], E] extends GenSpawn[F, E]:

  def ref[A](a: A): F[Ref[F, A]]
  def deferred[A]: F[Deferred[F, A]]
