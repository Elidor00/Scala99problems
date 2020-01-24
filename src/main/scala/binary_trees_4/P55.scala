package binary_trees_4

// Construct completely balanced binary trees.
// In a completely balanced binary tree, the following property holds for every node: The number of nodes in its left
// subtree and the number of nodes in its right subtree are almost equal, which means their difference is not greater than one.
// Define an object named Tree. Write a function Tree.cBalanced to construct completely balanced binary trees for a given number of nodes.
// The function should generate all solutions. The function should take as parameters the number of nodes and a single value to put in all of them.

abstract class P55 extends Tree

object P55 {

  def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
    case 0 => Nil
    case 1 => List(Node(value))
    // root and left child or root and right child
    case 2 => List(Node(value, Node(value), End), Node(value, End, Node(value)))
    case _ =>
      if (nodes % 2 == 1) {
        // odd nodes
        val LeftSubtree = cBalanced((nodes - 1) / 2, value)
        val RightSubtree = cBalanced((nodes - 1) / 2, value)
        val tree = LeftSubtree.flatMap(l => RightSubtree.map(r => Node(value, l, r)))
        tree
      } else {
        // even nodes
        val LeftSubtreeLesser = cBalanced(nodes / 2 - 1, value)
        val RightSubtreeGreater = cBalanced(nodes / 2, value)
        val tree1 = LeftSubtreeLesser.flatMap(l => RightSubtreeGreater.map(r => Node(value, l, r)))

        val LeftSubtreeGreater = cBalanced(nodes / 2, value)
        val RightSubtreeLesser = cBalanced(nodes / 2 - 1, value)
        val tree2 = LeftSubtreeGreater.flatMap(l => RightSubtreeLesser.map(r => Node(value, l, r)))
        val tree = tree1 ++ tree2
        tree
      }

  }

  def cBalanced2[T](n: Int, x: T): List[Tree[T]] = n match {
    case 0 => Nil
    case 1 => List(Node(x))
    case 2 => List(Node(x, Node(x), End), Node(x, End, Node(x)))
    case _ =>
      if (n % 2 == 0) {
        (for (l <- cBalanced(n / 2 - 1, x); r <- cBalanced(n / 2, x)) yield Node(x, l, r)) ++
          (for (l <- cBalanced(n / 2, x); r <- cBalanced(n / 2 - 1, x)) yield Node(x, l, r))
      } else {
        for (l <- cBalanced((n - 1) / 2, x); r <- cBalanced((n - 1) / 2, x)) yield Node(x, l, r)
      }
  }

  def main(args: Array[String]): Unit = {
    println(cBalanced(4, "x"))
    println(cBalanced2(4, "x"))

  }

}

