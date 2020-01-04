package list_1

import org.scalatest.{FunSpec, Matchers}

class P01Test extends FunSpec with Matchers {

  describe("P01 List builtin method") {
    it("should find last element") {
      val last = P01.lastElement(List("a", "b", "c", "d"))
      last should be("d")
    }
  }

}
