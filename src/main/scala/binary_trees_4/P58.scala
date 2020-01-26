package binary_trees_4

// Generate-and-test paradigm.
// Apply the generate-and-test paradigm to construct all symmetric, completely balanced binary trees with a given number of nodes.
// scala> Tree.symmetricBalancedTrees(5, "x")
// res0: List[Node[String]] = List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))

import binary_trees_4.P55.cBalanced

abstract class P58 extends Tree

object P58 {

  def symmetricBalancedTrees[T](nodes: Int, value: T): List[Tree[T]] = {
    cBalanced(nodes, value).filter(e => e.isSymmetric)
  }

  def main(args: Array[String]): Unit = {
    println(symmetricBalancedTrees(5, "x"))
  }

}
