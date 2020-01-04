package list_1

// Find the number of elements of a list.
// scala> length(List(1, 1, 2, 3, 5, 8))
// res0: Int = 6

object P04 {

  def length[A](l: List[A]): Int = {
    l match {
      case _ :: t => 1 + length(t)
      case Nil => 0
    }
  }

  def lengthTailRecursive[A](ls: List[A]): Int = {
    @scala.annotation.tailrec
    def lengthR(result: Int, curList: List[A]): Int = curList match {
      case Nil => result
      case _ :: tail => lengthR(result + 1, tail)
    }

    lengthR(0, ls)
  }

  def lengthFold[A](ls: List[A]): Int = ls.foldLeft(0) { (c, _) => c + 1 }

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8, 13, 14, 54, 54, 54, 76, 87, 65, 87)
    val l1 = 11 :: 11 :: 2 :: 3 :: 5 :: 9 :: Nil
    val l2 = Nil
    println(length(l))
    println(lengthTailRecursive(l))
    println(lengthFold(l))

    println(length(l1))
    println(length(l2))
  }
}
