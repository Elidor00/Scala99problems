package list_1

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P03Test extends AnyFunSpec with Matchers {

  describe("P03") {
    it("should find the second element of a list") {
      val nth = P03.nth(List("a", "b", "c", "d"), 2)
      nth should be("c")
    }

    it("should find the first element of a list") {
      val nth = P03.nth(List("a", "b", "c", "d"), 1)
      nth should be("b")
    }

    it("should throw NoSuchElementException when list is empty") {
      val thrown = the[NoSuchElementException] thrownBy P03.nth(List(), 0)
      thrown.getMessage should equal ("list is empty")
    }

    it("should find the first element of a list - v1") {
      val nth = P03.nth1(List("a", "b", "c", "d"), 1)
      nth should be("b")
    }

    it("should find the third element of a list - v1") {
      val nth = P03.nth1(List("a", "b", "c", "d"), 3)
      nth should be("d")
    }

    it("should throw NoSuchElementException when list is empty - v1") {
      val thrown = the[NoSuchElementException] thrownBy P03.nth1(List(), 0)
      thrown.getMessage should equal ("list is empty")
    }
  }

}
