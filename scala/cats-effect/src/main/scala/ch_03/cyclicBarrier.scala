package ch_03

import cats.effect.*
import cats.effect.std.CyclicBarrier
import utils.*
import scala.concurrent.duration.*
import cats.syntax.parallel.*

def batchRequest(id: Int, barrier: CyclicBarrier[IO]): IO[Unit] =
  for
    _ <- IO.pure(s"[request-$id] - registered").inspect
    _ <- IO.sleep(1.second)
    _ <- barrier.await
    _ <- IO.pure(s"[request-$id] - fulfilled").inspect
  yield ()

def batchRequests(batchSize: Int, numRequests: Int): IO[Unit] =
  for
    barrier <- CyclicBarrier[IO](batchSize)
    _       <- (1 to numRequests).toList.parTraverse(batchRequest(_, barrier))
  yield ()

// ex. implement CyclicBarrier
abstract class CyclicBarrierIO:
  def await: IO[Unit]

object CyclicBarrierIO:

  private[CyclicBarrierIO] final case class State(n: Int, signal: Deferred[IO, Unit])

  def apply(n: Int): IO[CyclicBarrierIO] =
    for
      signal <- IO.deferred[Unit]
      state  <- IO.ref(State(n, signal))
    yield new CyclicBarrierIO:

      override def await: IO[Unit] = IO.deferred[Unit].flatMap { newSignal =>
        state.modify {
          case State(1, oldSignal) => State(n, newSignal)     -> oldSignal.complete(()).void
          case State(n, oldSignal) => State(n - 1, oldSignal) -> oldSignal.get
        }.flatten
      }
