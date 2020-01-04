package list_1

// Create a list containing all integers within a given range.
// scala> range(4, 9)
// res0: List[Int] = List(4, 5, 6, 7, 8, 9)

object P22 {

  def range[A](start: Int, end: Int): List[Int] = {
    @scala.annotation.tailrec
    def rangeInt(result: List[Int], start: Int, end: Int): List[Int] = (start, end) match {
      case (start, end) if start > end => Nil
      case (start, end) if start == end => result :+ end
      case (start, end) => rangeInt(result :+ start, start + 1, end)
    }

    rangeInt(List(), start, end)
  }

  def rangeTailRecursive(start: Int, end: Int): List[Int] = {
    @scala.annotation.tailrec
    def rangeR(end: Int, result: List[Int]): List[Int] = {
      if (end < start) result
      else rangeR(end - 1, end :: result)
    }

    rangeR(end, Nil)
  }

  def main(args: Array[String]): Unit = {
    println(range(2, 20))
    println(rangeTailRecursive(3, 8))

  }

}
