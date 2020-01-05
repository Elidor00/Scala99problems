package list_1

// Find the Kth element of a list.
// scala> nth(2, List(1, 1, 2, 3, 5, 8))
// res0: Int = 2
// the first element in the list is element 0

import java.util.NoSuchElementException

object P03 {

  @scala.annotation.tailrec
  def nth[A](l: List[A], n: Int): A =
    l match {
      case h :: t => if (t.length == t.length - n) h else if (t.length + 1 < n) throw new NoSuchElementException("the list has less than " + n + " elements")
      else nth(t, n - 1)
      case Nil => throw new NoSuchElementException("list is empty")
    }

  @scala.annotation.tailrec
  def nth1[A](l: List[A], n: Int): A =
    (l, n) match {
      case (h :: _, 0) => h
      case (_ :: t, n) => nth1(t, n - 1)
      case (Nil, n) => throw new NoSuchElementException("list is empty")
    }

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    val l1 = 11 :: 11 :: 2 :: 3 :: 5 :: 9 :: Nil
    val l2 = Nil
    println(nth(l, 2))
    println(nth(l1, 5))
    println(nth(l1, 0))
    println(nth(l1, 20))
    println(nth(l2, 5))
  }

}
