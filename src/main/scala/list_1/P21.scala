package list_1

// Insert an element at a given position into a list.
// scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
// res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

object P21 {

  def insertAt[A](value: A, index: Int, l: List[A]): List[A] = {
    @scala.annotation.tailrec
    def insertAtInt(result: List[A], value: A, index: Int, l: List[A]): List[A] = (value, index, l) match {
      case (v, _, Nil) => result :+ v
      case (v, 0, h :: t) => t.:::(result :+ v :+ h)
      case (v, i, h :: t) => insertAtInt(result :+ h, v, i - 1, t)
    }

    insertAtInt(List(), value, index, l)
  }

  def insertAt2[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
    case (pre, post) => pre ::: e :: post
  }


  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd')
    println(insertAt(Symbol("new"), 4, l))
    println(insertAt2(Symbol("new"), 4, l))

  }

}
