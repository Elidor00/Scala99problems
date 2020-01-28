package binary_trees_4

// Count the leaves of a binary tree.
// A leaf is a node with no successors. Write a method leafCount to count them.
// scala> Node('x', Node('x'), End).leafCount
// res0: Int = 1

// Collect the leaves of a binary tree in a list.
// A leaf is a node with no successors. Write a method leafList to collect them in a list.
// scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
// res0: List[Char] = List(b, d, e)

abstract class P61 extends Tree

object P61 {
  def main(args: Array[String]): Unit = {
    println(Node('x', Node('x'), End).leafCount)
    println(Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList)
  }
}
