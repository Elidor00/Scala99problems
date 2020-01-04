package list_1

// Lotto: Draw N different random numbers from the set 1..M.
// scala> lotto(6, 49)
// res0: List[Int] = List(23, 1, 17, 33, 21, 37)

import scala.util.Random

object P24 {

  def lotto[A](n: Int, m: Int): List[Int] = {
    val r = new Random
    (for (_ <- 0 to n) yield r.nextInt(m)).toList
  }

  def main(args: Array[String]): Unit = {
    println(lotto(6, 49))

  }

}
