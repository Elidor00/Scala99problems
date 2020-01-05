package arithmetic_2

// Determine whether two positive integer numbers are coprime.
// Two numbers are coprime if their greatest common divisor equals 1.
// scala> 35.isCoprimeTo(64)
// res0: Boolean = true

import arithmetic_2.P32.gcd

object P33 {

  def areCoprime(a: Int, b: Int): Boolean =
    if (gcd(a, b) == 1) true else false

  def main(args: Array[String]): Unit = {
    println(areCoprime(35, 64))
  }

}
