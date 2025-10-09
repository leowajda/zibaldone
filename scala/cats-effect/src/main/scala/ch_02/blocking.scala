package ch_02

import cats.effect.*

import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.FiniteDuration

def semanticBlocking(duration: FiniteDuration): IO[Unit] = IO.sleep(duration)

// NOT semantic blocking - shifts computation to a blocking thread pool
def actualBlocking(duration: FiniteDuration): IO[Unit] = IO.blocking(Thread.sleep(duration.toMillis))

val ec: ExecutionContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(8))

// IO.cede is a fairness boundary that yields control back to the scheduler of the runtime system
// only needed for CPU bound applications
def cpuBoundCompute(hugeRange: Range): IO[Int] = hugeRange.map(IO.pure).reduce(_ >> IO.cede >> _).evalOn(ec)
