package list_1

// Run-length encoding of a list.
// Use the result of problem P09 to implement the so-called run-length encoding data compression method.
// Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
// scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

object P10 {

  def encode[A](l: List[A]): List[(Int, A)] = {
    @scala.annotation.tailrec
    def encodeInt(result: List[(Int, A)], curList: List[A], count: Int): List[(Int, A)] =
      curList match {
        case Nil => Nil
        case h :: Nil => result :+ (count, h)
        case h :: t => if (h.equals(t.head)) encodeInt(result, t, count + 1) else encodeInt(result :+ (count, h), t, 1)
      }

    encodeInt(List(), l, 1)
  }

  def pack2[A](ls: List[A]): List[List[A]] = {
    val (packed, next) = ls span { _ == ls.head }
    if (next == Nil) List(packed)
    else packed :: pack2(next)
  }

  def encode2[A](ls: List[A]): List[(Int, A)] =
    pack2(ls) map { e => (e.length, e.head) }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    println(encode(l))
    println(encode2(l))

  }

}
