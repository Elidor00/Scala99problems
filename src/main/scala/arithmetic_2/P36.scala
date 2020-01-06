package arithmetic_2

// Determine the prime factors of a given positive integer (2).
// Construct a list containing the prime factors and their multiplicity.
// scala> 315.primeFactorMultiplicity
// res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))

object P36 {

  def primeFactorMultiplicity(n: Int): List[(Int, Int)] =
    P35.primeFactors(n).distinct map { e => (e, P35.primeFactors(n).count(_ == e)) }

  def main(args: Array[String]): Unit = {
    println(primeFactorMultiplicity(315))
  }

}
