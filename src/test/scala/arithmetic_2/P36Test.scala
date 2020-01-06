package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P36Test extends AnyFunSpec with Matchers {

  describe("P36") {
    it("the prime factors and their multiplicity of 429 are (3,1), (11,1), (13,1)") {
      P36.primeFactorMultiplicity(429) should be(List((3, 1), (11, 1), (13, 1)))
    }

    it("the prime factors and their multiplicity of 12387 are (3,1), (4129,1)") {
      P36.primeFactorMultiplicity(12387) should be(List((3, 1), (4129, 1)))
    }

    it("the prime factors and their multiplicity of 4129 is (4129,1)") {
      P36.primeFactorMultiplicity(4129) should be(List((4129, 1)))
    }
  }

}
