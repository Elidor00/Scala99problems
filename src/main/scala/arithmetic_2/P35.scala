package arithmetic_2

// Determine the prime factors of a given positive integer.
// Construct a flat list containing the prime factors in ascending order.
// scala> 315.primeFactors
// res0: List[Int] = List(3, 3, 5, 7)

import arithmetic_2.P31.isPrime

object P35 {

  def primeFactors(n: Int): List[Int] = {
    @scala.annotation.tailrec
    def primeFactorsInt(result: List[Int], n: Int, start: Int): List[Int] = {
      if (isPrime(n)) result :+ n
      else if (n % start == 0) primeFactorsInt(result :+ start, n / start, start)
      else primeFactorsInt(result, n, start + 1)
    }

    primeFactorsInt(List(), n, 2)
  }

  def main(args: Array[String]): Unit = {
    println(primeFactors(315))
  }

}
