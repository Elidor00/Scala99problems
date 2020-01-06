package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P35Test extends AnyFunSpec with Matchers {

  describe("P35") {
    it("the prime factors of 429 are 3, 11, 13") {
      P35.primeFactors(429) should be(List(3, 11, 13))
    }

    it("the prime factors of 12387 are 3, 4129") {
      P35.primeFactors(12387) should be(List(3, 4129))
    }

    it("the prime factors of 4129 is 4129") {
      P35.primeFactors(4129) should be(List(4129))
    }
  }

}
