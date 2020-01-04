package list_1

// Remove the Kth element from a list.
// Return the list and the removed element in a Tuple. Elements are numbered from 0.
// scala> removeAt(1, List('a, 'b, 'c, 'd))
// res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

object P20 {

  def removeAt[A](index: Int, l: List[A]): (List[A], A) = (index, l) match {
    case (_, Nil) => (Nil, ().asInstanceOf)
    case (0, h :: t) => (t, h)
    // case (i, h :: t ) => removeAt(i - 1, t :+ h)
    case (i, l) =>
      val (l1, l2) = l.splitAt(i)
      (l1 ::: l2.tail, l2.head)
  }

  def removeAt2[A](index: Int, l: List[A]): (List[A], A) = (index, l) match {
    case (_, Nil) => (Nil, ().asInstanceOf)
    case (0, h :: t) => (t, h)
    case (i, h :: t) =>
      val (l1, l2) = removeAt2(i - 1, t) // (l1, l2) are parts of t. l2 always contains the element to be removed
      (h :: l1, l2)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e')
    println(removeAt(1, l))
    println(removeAt2(2, l))

  }

}
