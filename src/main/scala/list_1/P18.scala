package list_1

// Extract a slice from a list.
// Given two indices, I and K, the slice is the list containing the elements from and including the Ith element
// up to but not including the Kth element of the original list. Start counting the elements with 0.
// scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('d, 'e, 'f, 'g)

object P18 {

  def slice[A](from: Int, to: Int, l: List[A]): List[A] = {
    if (from > to) Nil
    else {
      val (l1, l2) = l splitAt (to)
      l1.drop(from)
    }
  }

  def sliceRecursive[A](start: Int, end: Int, ls: List[A]): List[A] =
    (start, end, ls) match {
      case (_, _, Nil) => Nil
      case (_, e, _) if e <= 0 => Nil
      case (s, e, h :: tail) if s <= 0 => h :: sliceRecursive(0, e - 1, tail)
      case (s, e, h :: tail) => sliceRecursive(s - 1, e - 1, tail)
    }

  def sliceBuiltin[A](start: Int, end: Int, ls: List[A]): List[A] =
    ls.slice(start, end) // ls drop start take (end - (start max 0))

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    println(slice(3, 7, l))
    println(sliceBuiltin(3, 7, l))
    println(sliceRecursive(3, 7, l))

  }

}
