package hierarchy

import cats.effect.kernel.Fiber

trait Spawn[F[_]] extends GenSpawn[F, Throwable]

trait GenSpawn[F[_], E] extends MonadCancel[F, E]:

  def start[A](fa: F[A]): F[Fiber[F, E, A]]
  def never[A]: F[A]
  def cede: F[Unit]
