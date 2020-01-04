package list_1

// Drop every Nth element from a list.
// scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

object P16 {

  // drop only one element
  def dropOneElement[A](n: Int, l: List[A]): List[A] = {
    val (l1, l2) = l splitAt (n - 1)
    l1 ::: (l2 drop 1)
  }

  // drop only one element
  def dropOneElement1[A](n: Int, l: List[A]): List[A] =
    l.take(n-1) ::: l.drop(n)

  def drop[A](n: Int, l: List[A]): List[A] = {
    val (l1, l2) = l splitAt (n - 1)
    l1 ++ l2.grouped(n).flatMap(_.drop(1))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    println(drop(3, l))

  }

}
