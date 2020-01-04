package list_1

// Modified run-length encoding.
// Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into
// the result list. Only elements with duplicates are transferred as (N, E) terms.
// scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

object P11 {

  def pack2[A](ls: List[A]): List[List[A]] = {
    val (packed, next) = ls span { _ == ls.head }
    if (next == Nil) List(packed)
    else packed :: pack2(next)
  }

  def encode2[A](ls: List[A]): List[Any] =
    pack2(ls) map { e => if (e.length > 1) (e.length,  e.head) else e.head }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    println(encode2(l))

  }

}
