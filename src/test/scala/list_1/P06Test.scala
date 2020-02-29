package list_1

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P06Test extends AnyFunSpec with Matchers {

  describe("P06") {
    it("should find out whether a list is a palindrome") {
      val palindrome = P06.isPalindrome(List(1, 2, 3, 2, 1))
      palindrome should be(true)

      val notPalindrome = P06.isPalindrome2(List("a", 1, "b"))
      notPalindrome should be(false)
    }
  }

}
