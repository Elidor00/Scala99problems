package arithmetic_2

// Determine whether a given integer number is prime.
// scala> 7.isPrime
// res0: Boolean = true

object P31 {

  /*
  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else {
      for (i <- 2 to Math.sqrt(n.toDouble).toInt) {
        if (n % i == 0) false
      }
      true
    }
  }
  */

  def isPrime(n: Int): Boolean =
    if (n <= 1) false
    else !(2 to Math.sqrt(n).toInt).exists(x => n % x == 0)

  def main(args: Array[String]): Unit = {
    println(isPrime(7))
    println(isPrime(8))
  }

}
