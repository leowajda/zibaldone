package hierarchy

import scala.concurrent.duration.FiniteDuration

trait Temporal[F[_]] extends GenTemporal[F, Throwable]

trait GenTemporal[F[_], E] extends GenConcurrent[F, E]:
  def sleep(duration: FiniteDuration): F[Unit]
