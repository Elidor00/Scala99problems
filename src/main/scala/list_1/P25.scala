package list_1

// Generate a random permutation of the elements of a list
// scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
// res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

import list_1.P23.randomSelectNotRep

object P25 {

  // for permutations it is necessary that the elements are all distinct from each other
  def randomPermute[A](l: List[A]): List[A] =
    randomSelectNotRep(l.length, l)

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f')
    println(randomPermute(l))

  }

}
