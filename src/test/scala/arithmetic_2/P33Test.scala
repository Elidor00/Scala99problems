package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P33Test extends AnyFunSpec with Matchers {

  describe("P33") {
    it("should determine if (35, 64) are coprime (gcd = 1)") {
      P33.areCoprime(35, 64) should be(true)
    }

    it("should determine if (12, 25) are coprime (gcd = 1)") {
      P33.areCoprime(12, 25) should be(true)
    }

    it("should determine if (15, 150) are coprime (gcd = 1)") {
      P33.areCoprime(15, 150) should be(false)
    }
  }

}
