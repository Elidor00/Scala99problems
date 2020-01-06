package arithmetic_2

// Compare the two methods of calculating Euler's totient function.
// Use the solutions of problems P34 and P37 to compare the algorithms.
// Try to calculate phi(10090) as an example.

import P34.totient
import P37.{totientImproved, totientImproved1}

object P38 {

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  def main(args: Array[String]): Unit = {
    println(time { totient(10090) })
    println(time { totientImproved(10090) })
    println(time { totientImproved1(10090) })
  }

}
