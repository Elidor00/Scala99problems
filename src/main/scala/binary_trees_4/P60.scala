package binary_trees_4

// Construct height-balanced binary trees with a given number of nodes.
// Consider a height-balanced binary tree of height H. What is the maximum number of nodes it can contain? Clearly, MaxN = 2H - 1.
// However, what is the minimum number MinN? This question is more difficult. Try to find a recursive statement and turn it into a function minHbalNodes that takes a height and returns MinN.
// scala> minHbalNodes(3)
// res0: Int = 4
// On the other hand, we might ask: what is the maximum height H a height-balanced binary tree with N nodes can have? Write a maxHbalHeight function.

// scala> maxHbalHeight(4)
// res1: Int = 3
// Now, we can attack the main problem: construct all the height-balanced binary trees with a given nuber of nodes.

// scala> Tree.hbalTreesWithNodes(4, "x")
// res2: List[Node[String]] = List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), ...
// Find out how many height-balanced trees exist for N = 15.

// root has height one (not zero)
//          root  (1)
//        node  node (2)
//      node            (3)

import java.lang.Math.pow

import binary_trees_4.P59.hbalTrees

abstract class P60 extends Tree

object P60 {

  // root has height one (not zero)

  // height = 2 min_node = 2
  // height = 3 min_node = 4
  // height = 4 min_node = 7
  // height = 5 min_node = 12
  // height = 6 min_node = 20
  // height = 7 min_nome = 33
  // ecc ecc

  // minimum number of nodes given height
  def minHbalNodes[T](height: Int): Int = height match {
    case 0 => 0
    case 1 => 1
    case _ =>
      minHbalNodes(height - 1) + minHbalNodes(height - 2) + 1
  }

  // maximum number of nodes given height
  def maxHbalNodes[T](height: Int): Int =
    pow(2, height).toInt - 1


  // maximum height-balanced binary tree given N nodes
  def maxHbalHeight[T](nodes: Int): Int = {
    @scala.annotation.tailrec
    def maxHbalHeightInt(height: Int, nodes: Int): Int = nodes match {
      case 0 => 0
      case 1 => 1
      case _ =>
        val min = minHbalNodes(height)
        val max = maxHbalNodes(height)
        if (nodes >= min && nodes < max) height else maxHbalHeightInt(height + 1, nodes)
    }

    maxHbalHeightInt(1, nodes)
  }

  // minimum height-balanced binary tree given N nodes
  def minHbalHeight[T](height: Int): Int = height match {
    case 0 => 0
    case _ => 1 + minHbalHeight(height / 2)
  }


  def hbalTreesWithNodes[T](nodes: Int, value: T): List[Tree[T]] =
    (minHbalHeight(nodes) to maxHbalHeight(nodes)).flatMap(hbalTrees(_, value)).filter(_.nodeCount == nodes).toList


  def main(args: Array[String]): Unit = {
    println("2 -> " + minHbalNodes(2))
    println("3 -> " + minHbalNodes(3))

    println(maxHbalHeight(12))
    println(minHbalHeight(12))

    println(hbalTreesWithNodes(4, "x"))
  }
}