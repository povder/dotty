trait Semigroup[T] {
  def (lhs: T) append (rhs: T): T
}

object Semigroup {
  implicit object stringAppend extends Semigroup[String] {
    override def (lhs: String) append (rhs: String): String = lhs + rhs
  }

  implicit def sumSemigroup[N](implicit N: Numeric[N]): Semigroup[N] = new {
    override def (lhs: N) append (rhs: N): N = ??? // N.plus(lhs, rhs)
  }

  implicit class SumSemigroupDeco[N](implicit N: Numeric[N]) extends Semigroup[N] {
    override def (lhs: N) append (rhs: N): N = ??? // N.plus(lhs, rhs)
  }
}


object Main {
  import Semigroup.sumSemigroup // this is not sufficient
  def f1 = {
    import Semigroup.stringAppend // necessary to make the extension method visible
    println("Hi" append " mum") // ok
    //sumSemigroup.apply(1)(2)
    println(1 append 2) // error: this won't compile
  }

  def f2 = {
    implicit val intSumAppend: Semigroup[Int] = sumSemigroup[Int]
    println(3 append 4) // this will
  }
}