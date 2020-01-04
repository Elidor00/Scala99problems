package list_1

// Duplicate the elements of a list.
// scala> duplicate(List('a, 'b, 'c, 'c, 'd))
// res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

object P14 {

  def duplicate[A](l: List[A]): List[A] =
    l flatMap { e => List[A] (e,e)}

  def duplicate2[T](l: List[T]): List[T] =
    l flatMap { x => List.fill(2)(x)}

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'c', 'd')
    println(duplicate(l))
    println(duplicate2(l))

  }

}
