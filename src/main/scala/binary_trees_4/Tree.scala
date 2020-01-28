package binary_trees_4

// covariant class [+T]
abstract class Tree[+T] {
  def isMirrorOf[A](tree: Tree[A]): Boolean

  def isSymmetric: Boolean

  // U supertype of type T
  // [U >: T <% Ordered[U]] view bounds are deprecated
  def addValue[U >: T](x: U)(implicit ev: U => Ordered[U]): Tree[U]

  def nodeCount: Int

  def leafCount: Int

  def leafList: List[T]

  def internalList: List[T]

  def atLevel(n: Int): List[T]
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

  override def leafCount: Int = (left, right) match {
    case (End, End) => 1
    case _ => left.leafCount + right.leafCount
  }

  // override def leafCount: Int = leafList.length

  override def leafList: List[T] = (left, right) match {
    case (End, End) => value :: left.leafList ::: right.leafList
    case _ => left.leafList ::: right.leafList
  }

  override def internalList: List[T] = (left, right) match {
    case (End, End) => Nil
    case _ => value :: left.internalList ::: right.internalList
  }

  override def atLevel(n: Int): List[T] = n match {
    case n if n < 1 => Nil
    case 1 => List(value)
    case n => left.atLevel(n - 1) ::: right.atLevel(n - 1)
  }
}

// empty tree
case object End extends Tree[Nothing] {
  override def toString = "."

  override def isMirrorOf[A](tree: Tree[A]): Boolean = tree == End

  override def isSymmetric: Boolean = true

  override def addValue[U >: Nothing](x: U)(implicit ev: U => Ordered[U]): Tree[U] = Node(x, End, End)

  override def nodeCount: Int = 0

  override def leafCount: Int = 0

  override def leafList: Nil.type = Nil

  override def internalList: Nil.type = Nil

  override def atLevel(n: Int): Nil.type = Nil
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
