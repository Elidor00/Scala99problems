package list_1

import org.scalatest.matchers.should.Matchers
import org.scalatest.funspec.AnyFunSpec

class P01Test extends AnyFunSpec with Matchers {

  describe("P01") {
    it("should find last element of a list") {
      val last = P01.lastElement(List("a", "b", "c", "d"))
      last should be("d")
    }

    it("should throw NoSuchElementException when list is empty") {
      val thrown = the[NoSuchElementException] thrownBy P01.lastElement(List())
      thrown.getMessage should equal ("list is empty")
    }
  }

}
