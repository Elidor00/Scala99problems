package list_1

// Reverse a list
// scala> reverse(List(1, 1, 2, 3, 5, 8))
// res0: List[Int] = List(8, 5, 3, 2, 1, 1)

object P05 {

  def reverse[A](l: List[A]): List[A] = {
    @scala.annotation.tailrec
    def reverseInt(result: List[A], curList: List[A]): List[A] = curList match {
      case Nil => result
      case h :: t => reverseInt(h +: result, t) //added element to head of list result
    }

    reverseInt(List(), l)
  }

  def reverseFold[A](ls: List[A]): List[A] = ls.foldLeft(List[A]()) ((res, h) => h :: res)

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8, 13, 14, 54, 54, 54, 76, 87, 65, 87)
    val l1 = 11 :: 11 :: 2 :: 3 :: 5 :: 9 :: Nil
    val l2 = Nil
    println(reverse(l))
    println(reverse(l1))
    println(reverse(l2))

    println("reverseFold" + reverseFold(l))

  }

}
