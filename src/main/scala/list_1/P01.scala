package list_1

// Find the last element of a list.
// scala> last(List(1, 1, 2, 3, 5, 8))
// res0: Int = 8

import java.util.NoSuchElementException

object P01 {
  @scala.annotation.tailrec
  def lastElement[A](l: List[A]): A =
    l match {
      case h :: Nil => h
      case _ :: t => lastElement(t)
      case Nil => throw new NoSuchElementException("list is empty")
    }

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    val l1 = 11 :: 11 :: 2 :: 3 :: 5 :: 9 :: Nil
    val l2 = Nil
    println(lastElement(l))
    println(lastElement(l1))
    println(lastElement(l2))
  }

}
