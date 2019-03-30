
object primes{
  def from (n:Int) : Stream[Int] = n #:: from(n+1)

  val nats = from (0)

  def sieve(s:Stream[Int]): Stream[Int] =
    s.head #::sieve(s.tail filter(_ % s.head !=0))

  val primes =sieve(from(2))

  primes.take(50).toList
}
