package binary_trees_4

// covariant class [+T]
abstract class Tree[+T] {
  def isMirrorOf[A](tree: Tree[A]): Boolean

  def isSymmetric: Boolean

  // U supertype of type T
  // [U >: T <% Ordered[U]] view bounds are deprecated
  def addValue[U >: T](x: U)(implicit ev: U => Ordered[U]): Tree[U]

  def nodeCount: Int
}

// branch has a value and two descendat trees
case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  override def isMirrorOf[A](tree: Tree[A]): Boolean = tree match {
    case t: Node[A] => left.isMirrorOf(t.right) && right.isMirrorOf(t.left)
    case _ => false
  }

  override def isSymmetric: Boolean = left.isMirrorOf(right)

  // Binary search trees
  override def addValue[U >: T](x: U)(implicit ev: U => Ordered[U]): Tree[U] =
    if (x < value) Node(value, left.addValue(x), right) else Node(value, left, right.addValue(x))

  override def nodeCount: Int = left.nodeCount + right.nodeCount + 1
}

// empty tree
case object End extends Tree[Nothing] {
  override def toString = "."

  override def isMirrorOf[A](tree: Tree[A]): Boolean = tree == End

  override def isSymmetric: Boolean = true

  override def addValue[U >: Nothing](x: U)(implicit ev: U => Ordered[U]): Tree[U] = Node(x, End, End)

  override def nodeCount: Int = 0
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
