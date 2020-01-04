package list_1

// Sorting a list of lists according to length of sublists.
// a) We suppose that a list contains elements that are lists themselves.
// The objective is to sort the elements of the list according to their length.
// E.g. short lists first, longer lists later, or vice versa..
// scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
// res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))

// b) Again, we suppose that a list contains elements that are lists themselves.
// But this time the objective is to sort the elements according to their length frequency;
// i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.
// scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
// res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))

import scala.collection.mutable

object P28 {

  def lsort[A](l: List[List[A]]): List[List[A]] =
    l.sortBy(_.length)

  def lsort1[A](l: List[List[A]]): List[List[A]] =
    l.sortWith(_.length < _.length)

  def lsort2[A](l: List[List[A]]): List[List[A]] =
    l.sortBy(l.groupBy(l => l).map(t => (t._1, t._1.length)))

  def lsortReverse[A](l: List[List[A]]): List[List[A]] =
    l.sortBy(_.length)(Ordering[Int].reverse)

  // works with lists whose elements are different from each other
  def lsortFreq[A](l: List[List[A]]): List[List[A]] = {
    val frequency = new mutable.HashMap[Int, mutable.Set[List[A]]] with mutable.MultiMap[Int, List[A]]
    l foreach (e => frequency.addBinding(e.length, e))
    val order = frequency.toSeq.sortBy(_._2.size)
    order.flatMap(_._2).toList
  }

  // works with all type of lists
  def lfsort[A](l: List[List[A]]): List[List[A]] =
    lsort(l)
      .groupBy(_.length).values.toList
      .sortBy(_.length)
      .flatten

  def main(args: Array[String]): Unit = {
    val l = List(List('a', 'b', 'c'), List('d', 'e'), List('f', 'g', 'h'), List('d', 'e'), List('i', 'j', 'k', 'l'), List('m', 'n'), List('o'))
    println(lsort(l))
    println(lsort2(l))
    println(lsort1(l))
    println(lsortReverse(l))
    println(lsortFreq(l))
    println(lfsort(l))

  }

}
