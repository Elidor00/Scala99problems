package list_1

// Duplicate the elements of a list a given number of times.
// scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
// res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

object P15 {

  def duplicateN[T](n:Int, l: List[T]): List[T] =
    l flatMap { x => List.fill(n)(x)}

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'c', 'd')
    println(duplicateN(3, l))
    println(duplicateN(1, l))

  }

}
