package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P37Test extends AnyFunSpec with Matchers {

  describe("P37") {
    it("phi(10) should return 4") {
      P37.totientImproved(10) should be(4)
    }
  }

}
