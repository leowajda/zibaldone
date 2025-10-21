package hierarchy

trait Sync[F[_]] extends MonadCancel[F, Throwable] with cats.Defer[F]:

  def delay[A](thunk: => A): F[A]
  def blocking[A](thunk: => A): F[A]

  override def defer[A](thunk: => F[A]): F[A] = flatMap(delay(thunk))(identity)
