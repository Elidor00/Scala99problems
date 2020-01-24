package binary_trees_4

// Symmetric binary trees.
// Let us call a binary tree symmetric if you can draw a vertical line through the root node and then the right subtree
// is the mirror image of the left subtree. Add an isSymmetric method to the Tree class to check whether a given binary tree is symmetric.
// Hint: Write an isMirrorOf method first to check whether one tree is the mirror image of another. We are only interested in the structure,
// not in the contents of the nodes.

abstract class P56 extends Tree

object P56 {
  def main(args: Array[String]): Unit = {
    println(Node('a', Node('b'), Node('c')).isSymmetric)
    println(Node('a', Node('b'), End).isSymmetric)

  }
}








