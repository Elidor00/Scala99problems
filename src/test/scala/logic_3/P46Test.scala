package logic_3

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P46Test extends AnyFunSpec with Matchers {

  // and vs and1
  // sometimes and1 is better than and
  describe("P46") {
    it("should calculates the and logical expressions - time") {
      for {a <- List(true, false)
           b <- List(true, false)} {
        val elapsedTime = P46.time1 {
          P46.and(a, b)
        }
        val elapsedTime1 = P46.time1 {
          P46.and1(a, b)
        }
        elapsedTime should be > elapsedTime1
      }
    }
  }

}
