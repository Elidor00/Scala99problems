package binary_trees_4

// Collect the internal nodes of a binary tree in a list.
// An internal node of a binary tree has either one or two non-empty successors. Write a method internalList to collect them in a list.
// scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
// res0: List[Char] = List(a, c)

// Collect the nodes at a given level in a list.
// A node of a binary tree is at level N if the path from the root to the node has length N-1. The root node is at level 1.
// Write a method atLevel to collect all nodes at a given level in a list.
// scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
// res0: List[Char] = List(b, c)
// Using atLevel it is easy to construct a method levelOrder which creates the level-order sequence of the nodes. However, there are more efficient ways to do that.


abstract class P62 extends Tree

object P62 {
  def main(args: Array[String]): Unit = {
    println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList)
    println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2))
  }
}
