package binary_trees_4

// Construct height-balanced binary trees.
// In a height-balanced binary tree, the following property holds for every node: The height of its left subtree and
// the height of its right subtree are almost equal, which means their difference is not greater than one.
// Write a method Tree.hbalTrees to construct height-balanced binary trees for a given height with a supplied value for the nodes.
// The function should generate all solutions.

// scala> Tree.hbalTrees(3, "x")
// res0: List[Node[String]] = List(T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .))), T(x T(x T(x . .) T(x . .)) T(x T(x . .) .)), ...

abstract class P59 extends Tree

object P59 {

  def hbalTrees[T](height: Int, value: T): List[Tree[T]] = height match {
    case 0 => Nil // List(End)
    case 1 => List(Node(value)) // root has height one (not zero)
    case _ =>
      // the height of subtrees is not greater than one
      // we need full trees, but also trees with a hole (without one node in subtree)
      val maxHeight = hbalTrees(height - 1, value)
      val minHeight = hbalTrees(height - 2, value)
      maxHeight.flatMap(l => maxHeight.map(r => Node(value, l, r))) :::
        maxHeight.flatMap(ll => minHeight.flatMap(rr => List(Node(value, ll, rr),
          Node(value, rr, ll))))
  }

  def main(args: Array[String]): Unit = {
    println(hbalTrees(3, "x"))
  }

}

/*
Scala "nested loop":
val list = List(1, 2, 3)

list.flatMap(e => list.map(ee => e + ee))
output: List(2, 3, 4, 3, 4, 5, 4, 5, 6)
---------------------------------------------------
Python nested loop:
l = [1,2,3]

for e in l:
   for ee in l:
      print(e + ee)
output: 2, 3, 4, 3, 4, 5, 4, 5, 6
 */