package binary_trees_4

// Binary search trees (dictionaries).
// Write a function to add an element to a binary search tree.
// scala> End.addValue(2)
// res0: Node[Int] = T(2 . .)

// scala> res0.addValue(3)
// res1: Node[Int] = T(2 . T(3 . .))

// scala> res1.addValue(0)
// res2: Node[Int] = T(2 T(0 . .) T(3 . .))
// Hint: The abstract definition of addValue in Tree should be def addValue[U >: T <% Ordered[U]](x: U): Tree[U]. The >: T is because addValue's parameters need to be contravariant in T. (Conceptually, we're adding nodes above existing nodes. In order for the subnodes to be of type T or any subtype, the upper nodes must be of type T or any supertype.) The <% Ordered[U] allows us to use the < operator on the values in the tree.

// Use that function to construct a binary tree from a list of integers.

// scala> Tree.fromList(List(3, 2, 5, 7, 1))
// res3: Node[Int] = T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))

abstract class P57 extends Tree

object P57 {

  def fromList[T](l: List[T])(implicit ev: T => Ordered[T]): Tree[T] =
    l.foldLeft(End: Tree[T])((t, x) => t.addValue(x))

  def main(args: Array[String]): Unit = {
    val res0 = End.addValue(2)
    val res1 = res0.addValue(3)
    val res2 = res1.addValue(0)
    println(res2)
    println(fromList(List(3, 2, 5, 7, 1)))
    println(fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric)
    println(fromList(List(3, 2, 5, 7, 4)).isSymmetric)
  }

}