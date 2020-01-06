package arithmetic_2

// Calculate Euler's totient function phi(m) (improved).
// If the list of the prime factors of a number m is known in the form of problem P36 then the function phi(m>)
// can be efficiently calculated as follows: Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors (and their multiplicities)
// of a given number m. Then phi(m) can be calculated with the following formula:
// phi(m) = (p1-1)*p1(m1-1) * (p2-1)*p2(m2-1) * (p3-1)*p3(m3-1) * ...
// Note that ab stands for the bth power of a.

object P37 {

  def totientImproved(n: Int): Int = {
    val result = P36.primeFactorMultiplicity(n) map { e => e._1 - 1 * Math.pow(e._1, e._2 - 1).toInt }
    result.product
  }

  def totientImproved1(n: Int): Int = {
    P36.primeFactorMultiplicity(n).map { case (p, m) => p - 1 * Math.pow(p, m - 1).toInt }.product
  }

  def main(args: Array[String]): Unit = {
    println(totientImproved(10))
    println(totientImproved1(10))
  }

}
