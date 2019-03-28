import sun.nio.cs.Surrogate

trait Generator[+T]{
  self =>   // alias for this
  def generate : T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate = f(self.generate)  // if this is used then the program would enter endless loop
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    def generate = f(self.generate).generate
  }
}

trait Tree

case class Inner(left:Tree, right:Tree) extends Tree

case class Leaf(x:Int) extends Tree

object generators{

  val integers = new Generator[Int]{
    def generate = scala.util.Random.nextInt()
  }

  val booleans =  integers.map(_ >= 0)

  def leafs: Generator[Leaf]= for {
    x <- integers
  } yield Leaf(x)

  def inners: Generator[Inner]= for {
    l <- trees
    r <- trees
  } yield Inner(l,r)

  def trees: Generator[Tree]= for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree

  trees.generate

  trees.generate
}

