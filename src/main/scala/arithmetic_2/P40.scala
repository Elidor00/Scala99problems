package arithmetic_2

// Goldbach's conjecture.
// Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
// E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
// It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
// Write a function to find the two prime numbers that sum up to a given even integer.

import arithmetic_2.P39.listPrimesinRange

object P40 {

  def goldbachBool(n: Int): Boolean =
    listPrimesinRange(1 to n).combinations(2).map(_.sum).contains(n)

  // find returns an Option[...] because it can not guarantee that a matching element gets found
  def goldbach(n: Int): (Int, Int) =
    listPrimesinRange(1 to n) find { e => listPrimesinRange(1 to n).contains(n - e) } match {
      case None => throw new NoSuchElementException
      case Some(e1) => (e1, n - e1)
    }

  def main(args: Array[String]): Unit = {
    println(goldbach(28))
  }

}
