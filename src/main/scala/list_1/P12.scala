package list_1

// Decode a run-length encoded list.
// Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
// scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
// res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

object P12 {

  def pack2[A](ls: List[A]): List[List[A]] = {
    val (packed, next) = ls span { _ == ls.head }
    if (next == Nil) List(packed)
    else packed :: pack2(next)
  }

  def encode2[A](ls: List[A]): List[(Int, A)] =
    pack2(ls) map { e => (e.length, e.head) }

  def decode[A](ls: List[(Int, A)]): List[A] =
    ls flatMap { t => {
      for (i <- 1 to t._1) yield {
        t._2
      }
    }}

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    val lenc = encode2(l)
    println("encode " + lenc)
    val ldec = decode(lenc)
    println("decode " + ldec)

  }

}
