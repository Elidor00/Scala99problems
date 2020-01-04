package list_1

// Run-length encoding of a list (direct solution).
// Implement the so-called run-length encoding data compression method directly.
// I.e. don't use other methods you've written (like P09's pack); do all the work directly.
// scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

object P13 {

  def encodeDirect[A](l: List[A]): List[(Int, A)] =
    if (l.isEmpty) Nil
    else {
      val (packed, next) = l span { _ == l.head }
      (packed.length, packed.head) :: encodeDirect(next)
    }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    println(encodeDirect(l))

  }

}
