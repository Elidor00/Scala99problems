package list_1

// Rotate a list N places to the left.
// scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
// scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
// res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

// import Math.abs

object P19 {

  @scala.annotation.tailrec
  def rotate[A](n: Int, l: List[A]): List[A] = (n, l) match {
    case (_, Nil) => Nil
    case (0, l) => l
    case (n, h :: t) if n > 0 => rotate(n - 1, t :+ h)
    case (n, h :: t) if n < 0 => rotate(l.length - (-(n - 1)), t :+ h)
    //case (n, h :: t) if n < 0 => rotate(l.length - (n.abs + 1), t :+ h)
  }

  def rotate2[A](n: Int, ls: List[A]): List[A] = {
    val nBounded = if (ls.isEmpty) 0 else n % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    else (ls drop nBounded) ::: (ls take nBounded)
  }

  def main(args: Array[String]): Unit = {
    val l = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    println(rotate(3, l))
    println(rotate(-2, l))
    println(rotate2(-2, l))

  }

}
