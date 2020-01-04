package list_1

// Find the last but one element of a list.
// scala> penultimate(List(1, 1, 2, 3, 5, 8))
// res0: Int = 5

import java.util.NoSuchElementException

object P02 {
  @scala.annotation.tailrec
  def penultimate[A](l: List[A], lenght: Int): A =
    l match {
      case h :: t => if (t.length == 1) h else penultimate(t, lenght - 1)
      case Nil => throw new NoSuchElementException("list is empty")
    }

  @scala.annotation.tailrec
  def penultimate1[A](l: List[A]): A =
    l match {
      case h :: _ :: Nil => h
      case _ :: t => penultimate1(t)
      case Nil => throw new NoSuchElementException("list is empty")
    }

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8)
    val l1 = 11 :: 11 :: 2 :: 3 :: 5 :: 9 :: Nil
    val l2 = Nil
    println(penultimate(l, l.length))
    println(penultimate(l1, l1.length))

    println(penultimate1(l))
    println(penultimate1(l1))

    println(penultimate(l2, l2.length))
  }
}
