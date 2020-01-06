package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P34Test extends AnyFunSpec with Matchers {

  describe("P34") {
    it("phi(10) should return 4") {
      P34.totient(10) should be(4)
    }
  }

  describe("P34") {
    it("phi(10) should return 4 - v2") {
      P34.totient2(10) should be(4)
    }
  }

}
