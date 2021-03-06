package arithmetic_2

// A list of prime numbers.
// Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
// scala> listPrimesinRange(7 to 31)
// res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

import arithmetic_2.P31.isPrime

object P39 {

  def listPrimesinRange(range: Range): List[Int] =
    range.filter(isPrime).toList

  def main(args: Array[String]): Unit = {
    println(listPrimesinRange(7 to 31))
  }

}
