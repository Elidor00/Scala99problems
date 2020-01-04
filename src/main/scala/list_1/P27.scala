package list_1

// Group the elements of a set into disjoint subsets.
// a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons?
// Write a function that generates all the possibilities.
// scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
// res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...

// b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.
// scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
// res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...

import list_1.P26.combinations

object P27 {

  def group3[A](l: List[A]): List[List[List[A]]] =
    for {
      a <- combinations(2, l)
      noA = l diff a
      b <- combinations(3, noA)
      noAB = l diff a diff b
      c <- combinations(4, noAB)
    } yield List(a, b, c)

  // only with size.length == 3
  def group[A](size: List[Int], l: List[A]): List[List[List[A]]] =
    if (size.sum != l.length) throw new Error("The sum of the cardinality of the subgroups is different from that of the main group") else
      for {
        a <- combinations(size(0), l)
        noA = l diff a
        b <- combinations(size(1), noA)
        noAB = l diff a diff b
        c <- combinations(size(2), noAB)
      } yield List(a, b, c)

  // foreach size.length
  def groupGen[A](size: List[Int], l: List[A]): List[List[List[A]]] = size match {
    case Nil => List(Nil)
    case h :: t => combinations(h, l) flatMap { c =>
      groupGen(t, l diff c) map {
        c :: _
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val l = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
    println("groups of 2 3 4 element: " + group3(l)) // 1260 combinations
    val ll = List(2, 2, 5)
    println("groups of 2 2 5 element: " + group(ll, l))
    val lll = List(2, 2, 2, 3)
    println("groups of 2 2 2 3 element: " + groupGen(lll, l))

  }

}
