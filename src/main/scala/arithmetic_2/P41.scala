package arithmetic_2

// A list of Goldbach compositions.
// Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
// scala> printGoldbachList(9 to 20)
// 10 = 3 + 7
// 12 = 5 + 7
// 14 = 3 + 11
// 16 = 3 + 13
// 18 = 5 + 13
// 20 = 3 + 17

import arithmetic_2.P40.goldbach

object P41 {

  def printGoldbachList(range: Range): List[(Int, (Int, Int))] =
    range.filter(x => x > 2 && x % 2 == 0).toList map { e => (e, goldbach(e)) }

  def main(args: Array[String]): Unit = {
    println(printGoldbachList(9 to 20))
    println(printGoldbachList(1 to 10))
  }

}
