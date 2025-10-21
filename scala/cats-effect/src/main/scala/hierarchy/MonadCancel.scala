package hierarchy

// onCancel, guarantee, guaranteeCase, bracket
trait MonadCancel[F[_], E] extends cats.MonadError[F, E]:

  def canceled: F[Unit]
  def uncancelable[A](poll: Poll[F] => F[A]): F[A]

trait Poll[F[_]]:
  def apply[A](fa: F[A]): F[A]
