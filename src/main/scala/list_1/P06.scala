package list_1

// Find out whether a list is a palindrome.
// scala> isPalindrome(List(1, 2, 3, 2, 1))
// res0: Boolean = true

object P06 {

  @scala.annotation.tailrec
  def isPalindrome[A](l: List[A]): Boolean =
    l match {
      case Nil => true
      case _ :: Nil => true
      case h :: t => if (t.tail.contains(h) || t.contains(h)) isPalindrome(t.slice(0, t.size - 1)) else false
    }

  def isPalindrome2[A](ls: List[A]): Boolean = ls == ls.reverse

  def main(args: Array[String]): Unit = {
    val l = List(1, 1, 2, 3, 5, 8, 13, 14, 54, 54, 54, 76, 87, 65, 87)
    val l1 = 11 :: 11 :: 2 :: 3 :: 5 :: 9 :: Nil
    val l2 = Nil
    val l3 = List(1, 2, 3, 2, 1)
    val l4 = List(1, 2, 2, 1)
    println(isPalindrome(l))
    println(isPalindrome(l1))
    println(isPalindrome(l2))
    println(isPalindrome(l3))
    println(isPalindrome(l4))

    println("isPalindrome2 " + isPalindrome2(l3))
    println("isPalindrome2 " + isPalindrome2(l4))

  }

}
