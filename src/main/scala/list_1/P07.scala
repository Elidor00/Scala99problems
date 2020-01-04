package list_1

// Flatten a nested list structure.
// scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
// res0: List[Any] = List(1, 1, 2, 3, 5, 8)

object P07 {

  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => Nil
    case (head: List[_]) :: tail => flatten(head) ++ flatten(tail)
    case head :: tail => head :: flatten(tail)
  }

  def flatten2(ls: List[Any]): List[Any] = ls flatMap { ls =>
    ls match {
      case ms: List[_] => flatten2(ms) // ms = list with a non specified type [_]
      case e => List(e) // e = element with type Any
    }
  }

  def main(args: Array[String]): Unit = {
    val l = List(List(1, 1), 2, List(3, List(5, 8)))
    println(flatten(l))
    println(flatten2(l))

  }

}
