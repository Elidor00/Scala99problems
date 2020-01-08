package logic_3

// Gray code.
// An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
// n = 1: C(1) = ("0", "1").
// n = 2: C(2) = ("00", "01", "11", "10").
// n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
// Find out the construction rules and write a function to generate Gray codes.

object P49 {

  def gray[A](n: Int, l: List[A]): List[List[A]] =
    n match {
      case 0 => List(List())
      case _ => for (el <- l;
                     sl <- gray(n - 1, l))
        yield el :: sl
    }

  def gray1(n: Int): List[String] = {
    if (n == 1) {
      List("0", "1")
    } else {
      val original = gray1(n - 1)
      val reversed = original.reverse
      original.map("0" + _) ++ reversed.map("1" + _) // prepend original with reverse
    }
  }

  def gray2(n: Int): List[String] = {
    def gray2Int(result: List[String], n: Int): List[String] =
      n match {
        case 0 => List("")
        case 1 => List("0", "1")
        case _ => gray2Int(result, n - 1).map("0" + _) ++ gray2Int(result, n - 1).map("1" + _).reverse
      }

    gray2Int(List(), n)
  }

  /* TODO: try to do gray tail recursive
  def grayTailRec(n:Int): List[String] = {
    @scala.annotation.tailrec
    def grayTailRecInt(result: List[String], n:Int, l0:List[String], l1:List[String]): List[String] =
      n match {
        case 0 => List("")
        case 1 => result
        case _ => grayTailRecInt(result ++ l0 ++ l1, n - 1, List("0", "1").map("0" + _), List("0", "1").map("1" + _).reverse)
      }

    grayTailRecInt(List(), n + 1, List(), List())
  }
   */


  def main(args: Array[String]): Unit = {
    println(gray(3, List("0", "1")))
    println(gray1(3))
    println(gray2(3))
    // println(gray3(1))
  }

}
