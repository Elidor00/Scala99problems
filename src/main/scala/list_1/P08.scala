package list_1

// Eliminate consecutive duplicates of list elements.
// If a list contains repeated elements they should be replaced with a single copy of the element.
// The order of the elements should not be changed.
// scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

object P08 {

  def compress(l: List[Any]): List[Symbol] = {
    @scala.annotation.tailrec
    def compressInt(result: List[Symbol], curList: List[Any]): List[Symbol] =
      curList match {
        case Nil => Nil
        case h :: Nil => result :+ Symbol(h.toString)
        case h :: t => if (h.equals(t.head)) compressInt(result, t) else compressInt(result :+ Symbol(h.toString), t)
      }

    compressInt(List(), l)
  }

  def compress2[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => h :: compress2(tail.dropWhile(_ == h))
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    val l1 = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e')
    println(compress(l))
    println(compress(l1))
    println(compress2(l))

  }

}
