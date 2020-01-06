package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P32Test extends AnyFunSpec with Matchers {

  describe("P32") {
    it("should determine if 9 is the greatest common divisor of (36, 63)") {
      P32.gcd(36, 63) should be(9)
    }

    it("should determine if 12 is the greatest common divisor of (324, 3432)") {
      P32.gcd(324, 3432) should be(12)
    }

    it("should determine if 1 is the greatest common divisor of (23, 45)") {
      P32.gcd(23, 45) should be(1)
    }
  }

}

