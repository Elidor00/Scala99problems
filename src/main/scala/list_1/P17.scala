package list_1

// Split a list into two parts.
// The length of the first part is given. Use a Tuple for your result.
// scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

object P17 {

  def split[A](n:Int, l:List[A]): (List[A], List[A]) =
    l.splitAt(n)

  def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) =
    (ls.take(n), ls.drop(n))

  def splitRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = (n, ls) match {
    case (_, Nil)       => (Nil, Nil)
    case (0, list)      => (Nil, list)
    case (n, h :: t) =>
      val (pre, post) = splitRecursive(n - 1, t)
      (h :: pre, post)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    println(split(3, l))
    println(splitFunctional(3, l))
    println(splitRecursive(3, l))

  }

}
