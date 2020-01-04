package list_1

// Generate the combinations of K distinct objects chosen from the N elements of a list.
// In how many ways can a committee of 3 be chosen from a group of 12 people?
// We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient).
// For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
// scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
// res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

object P26 {

  // built-in
  def combinations[A](k: Int, list: List[A]): List[List[A]] =
    list.combinations(k).toList

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f')
    println(combinations(3, l)) // 20 combinations

  }

}
