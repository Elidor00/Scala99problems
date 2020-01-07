package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P40Test extends AnyFunSpec with Matchers {

  describe("P40") {
    it("Goldbach's conjecture of 28 returns (5, 23)") {
      P40.goldbach(28) should be((5, 23))
    }

    it("Goldbach's conjecture of 100 returns (3, 97)") {
      P40.goldbach(100) should be((3, 97))
    }
  }

}
