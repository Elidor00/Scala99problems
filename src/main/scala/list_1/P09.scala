package list_1

// Pack consecutive duplicates of list elements into sublists.
// If a list contains repeated elements they should be placed in separate sublists.
// scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

object P09 {

  def pack[A](l: List[A]): List[List[A]] = {
    @scala.annotation.tailrec
    def packInt(result: List[List[A]], curList: List[A]): List[List[A]] =
      curList match {
        case Nil => result
        case h :: t => if (result.isEmpty || result.last.head != h) packInt(result ::: List(List(h)), t) else packInt(result.init ::: List(result.last ::: List(h)), t)
      }

    packInt(List(), l)
  }

  def pack2[A](ls: List[A]): List[List[A]] = {
    val (packed, next) = ls span { _ == ls.head }
    if (next == Nil) List(packed)
    else packed :: pack2(next)
  }

  def pack3[A](l: List[A]): List[List[A]] = {
    def packInt(result: List[List[A]], curList: List[A]): List[List[A]] =
      curList match {
        case Nil => result
        case _ =>
          val (p, n) = curList span { _ == curList.head }
          if (n == Nil) List(p)
          else p :: packInt(result :+ p, n)
      }

    packInt(List(), l)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    println(pack(l))
    println(pack2(l))
    println(pack3(l))

  }

}
