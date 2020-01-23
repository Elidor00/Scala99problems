package logic_3

// Huffman code.
// First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman codes!
// We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples.
// E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)). Our objective is to construct a list of (S, C)
// Tuples, where C is the Huffman code word for the symbol S.
// scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
// res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))

object P50 {

  /*
  sealed abstract class Tree[+T]
  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
    override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  }
  case object End extends Tree[Nothing] {
    override def toString = "."
  }
  object Node {
    def apply[T](value: T): Node[T] = Node(value, End, End)
  }
   */

  def huffman[A](l: List[(String, Int)]): List[(String, String)] = {
    var sorted = l.sortBy(_._2) // dal più piccolo al più grande
    var res: List[(String, String)] = List()
    while (sorted.size >= 2) {
      val el = (sorted(0), sorted(1))
      sorted = sorted.drop(2)
      res = res :+ ("dx " + el._1._1, el._1._2.toString) :+ ("sx " + el._2._1, el._2._2.toString)
      // val new_el = ((el._1._1 + el._2._1), el._1._2 + el._2._2)
      val new_el = ("root", el._1._2 + el._2._2)
      sorted = sorted.appended(new_el).sortBy(_._2)
      // res = res.appended(new_el._1, new_el._2.toString)
      res = res.appended("root", new_el._2.toString)
    }
    res
  }

  /* TODO: assign a code to each element
  def toCode[A](l: List[(String, String)]): List[(String, String)] = {
    var listTocode = l.reverse
    println(listTocode)
    var res: List[(String, String)] = List()
    var valore0 = ""
    var valore1 = ""
    while (listTocode.nonEmpty) {
      val tmp = listTocode(0)
      listTocode = listTocode.slice(1, listTocode.size)
      if (tmp._1.contains("dx")) {
        if (!tmp._1.contains("root")) {
          res = res :+ (tmp._1.replace("dx", ""), valore1)
        } else {
          valore1 = valore1.concat("1")
          valore0 = valore0.concat("1")
        }
      } else if (tmp._1.contains("sx")) {
        if (!tmp._1.contains("root")) {
          res = res :+ (tmp._1.replace("sx", ""), valore0)
        } else {
          valore1 = valore1.concat("0")
          valore0 = valore0.concat("0")
        }
      }
    }
    res
  }
   */

  def main(args: Array[String]): Unit = {
    val l = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))
    println(huffman(l))

  }

  // graphic visualization
  // input: aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbccccccccccccddddddddddddddddeeeeeeeeefffff
  // https://people.ok.ubc.ca/ylucet/DS/Huffman.html

}


