package binary_trees_4

abstract class Tree[+T] {
  def isMirrorOf[A](tree: Tree[A]): Boolean

  def isSymmetric: Boolean
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  override def isMirrorOf[A](tree: Tree[A]): Boolean = tree match {
    case Node(_, left, right) => left.isMirrorOf(right) && right.isMirrorOf(left)
    case _ => false
  }

  override def isSymmetric: Boolean = left.isMirrorOf(right)
}

case object End extends Tree[Nothing] {
  override def toString = "."

  override def isMirrorOf[A](tree: Tree[A]): Boolean = tree == End

  override def isSymmetric: Boolean = true
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
