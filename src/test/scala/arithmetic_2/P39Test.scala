package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P39Test extends AnyFunSpec with Matchers {

  describe("P39") {
    it("constructs a list of all prime numbers in range(7 to 31)") {
      P39.listPrimesinRange(7 to 31) should be(List(7, 11, 13, 17, 19, 23, 29, 31))
    }

    it("constructs a list of all prime numbers in range(1 to 100)") {
      P39.listPrimesinRange(1 to 100) should be(List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97))
    }
  }

}
