package ch_01

final case class IO[A](unsafeRun: () => A):

  def map[B](f: A => B): IO[B]         = IO(() => f(unsafeRun()))
  def flatMap[B](f: A => IO[B]): IO[B] = IO(() => f(unsafeRun()).unsafeRun())

// ex. IO which returns the current time
val clock: IO[Long] = IO(() => System.currentTimeMillis())

// ex. IO which measures the duration of a computation
def measure[A](computation: IO[A]): IO[Long] =
  for
    start <- clock
    _     <- computation
    end   <- clock
  yield end - start

// ex. IO which prints to the console
def putStrLn(line: String): IO[Unit] = IO(() => println(line))

// ex. IO which reads from the console
def readStrLn(): IO[String] = IO(() => io.StdIn.readLine())

// IO bridges functional and imperative programming
val program: IO[Unit] =
  for
    _         <- putStrLn("args[0]")
    firstArg  <- readStrLn()
    _         <- putStrLn("args[1]")
    secondArg <- readStrLn()
    _         <- putStrLn(s"$firstArg $secondArg")
  yield ()
