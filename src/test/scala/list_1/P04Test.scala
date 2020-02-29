package list_1

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P04Test extends AnyFunSpec with Matchers {

  describe("P04") {
    it("should find the number of elements of a list - lenght function") {
      val length = P04.length(List("a", "b", "c", "d"))
      length should be(4)

      val len = P04.length(List())
      len should be(0)
    }
  }

  describe("P04") {
    it("should find the number of elements of a list - lengthTailRecursive function") {
      val lengthTR = P04.lengthTailRecursive(List("a", "b", "c", "d"))
      lengthTR should be(4)

      val lenTR = P04.lengthTailRecursive(List())
      lenTR should be(0)
    }
  }

}
