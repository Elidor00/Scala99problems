package arithmetic_2

// Calculate Euler's totient function phi(m).
// Euler's so-called totient function phi(m) is defined as the
// number of positive integers r (1 <= r <= m) that are coprime to m.
// scala> 10.totient
// res0: Int = 4

import arithmetic_2.P32.gcd

object P34 {

  def totient(n: Int): Int = {
    var count = 0
    for (i <- 1 to n) {
      if (gcd(i, n) == 1) count += 1
    }
    count
  }

  def totient2(n: Int): Int = {
    (1 to n).count(gcd(_, n) == 1)
  }

  def main(args: Array[String]): Unit = {
    println(totient(10))
    println(totient2(10))
  }

}
