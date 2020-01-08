package logic_3

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P49Test extends AnyFunSpec with Matchers {

  describe("P49") {
    it("should generates Gray codes for 1") {
      P49.gray2(1) should be(List("0", "1"))
    }

    it("should generates Gray codes for 2") {
      P49.gray2(2) should be(List("00", "01", "11", "10"))
    }

    it("should generates Gray codes for 3") {
      P49.gray2(3) should be(List("000", "001", "011", "010", "110", "111", "101", "100"))
    }
  }

}
