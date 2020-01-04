package list_1

// Extract a given number of randomly selected elements from a list.
// scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
// res0: List[Symbol] = List('e, 'd, 'a)

import list_1.P20.removeAt

import scala.util.Random

object P23 {

  // randomly chosen elements can be repeated
  def randomSelectRep[A](n: Int, l: List[A]): List[A] = {
    @scala.annotation.tailrec
    def randomSelectInt(result: List[A], n: Int, l: List[A]): List[A] = (n, l) match {
      case (_, Nil) => result
      case (0, _) => result
      case (n, l) => randomSelectInt(result :+ removeAt(new Random().nextInt(l.length), l)._2, n - 1, l)
    }

    randomSelectInt(List(), n, l)
  }

  // instead of creating a new Random instance every time, I only do it once.
  // randomly chosen elements can be repeated
  def randomSelectRep1[A](n: Int, l: List[A]): List[A] = {
    @scala.annotation.tailrec
    def randomSelectInt(result: List[A], r: Random, n: Int, l: List[A]): List[A] = (n, l) match {
      case (_, Nil) => result
      case (0, _) => result
      case (n, l) => randomSelectInt(result :+ removeAt(r.nextInt(l.length), l)._2, r, n - 1, l)
    }

    randomSelectInt(List(), new Random(), n, l)
  }

  // randomly chosen elements are not repeated
  def randomSelectNotRep[A](n: Int, l: List[A]): List[A] = {
    @scala.annotation.tailrec
    def randomSelectInt(result: List[A], r: Random, n: Int, l: List[A]): List[A] = (n, l) match {
      case (_, Nil) => result
      case (0, _) => result
      case (n, l) =>
        val (l1, l2) = removeAt(r.nextInt(l.length), l) // l1 = list without element, l2 = the element
        randomSelectInt(result :+ l2, r, n - 1, l1)
    }

    randomSelectInt(List(), new Random(), n, l)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h')
    println("with repeated element: " + randomSelectRep(3, l))
    println("with repeated element: " + randomSelectRep1(3, l))
    println("without repeated element: " + randomSelectNotRep(3, l))

  }

}
