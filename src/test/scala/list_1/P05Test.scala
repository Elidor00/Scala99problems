package list_1

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P05Test extends AnyFunSpec with Matchers {

  describe("P05") {
    it("should reverse a list - reverse function") {
      val reverse = P05.reverse(List(4, 5, 6, "a"))
      reverse should be(List("a", 6, 5, 4))

      val reverseEmpty = P05.reverse(List())
      reverseEmpty should be(List())
    }
  }

  describe("P05") {
    it("should reverse a list - reverse fold function") {
      val reverseFold = P05.reverse(List(4, "b", 6, "a"))
      reverseFold should be(List("a", 6, "b", 4))
    }
  }

}
