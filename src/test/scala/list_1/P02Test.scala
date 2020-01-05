package list_1

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P02Test extends AnyFunSpec with Matchers {

  describe("P02") {
    it("should find last but one element of a list") {
      val list = List("a", "b", "c", "d")
      val penultimate = P02.penultimate(list, list.length)
      penultimate should be("c")
    }

    it("should throw NoSuchElementException when list is empty") {
      val list = List()
      val thrown = the[NoSuchElementException] thrownBy P02.penultimate(list, list.length)
      thrown.getMessage should equal ("list is empty")
    }

    it("should find last but one element of a list - v1") {
      val penultimate1 = P02.penultimate1(List("a", "b", "c", "d"))
      penultimate1 should be("c")
    }

    it("should throw NoSuchElementException when list is empty - v1") {
      val thrown = the[NoSuchElementException] thrownBy P02.penultimate1(List())
      thrown.getMessage should equal ("list is empty")
    }
  }

}
