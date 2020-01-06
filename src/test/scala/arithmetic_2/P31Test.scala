package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P31Test extends AnyFunSpec with Matchers {

  describe("P31") {
    it("should determine if 1 is a prime number") {
      P31.isPrime(1) should be(false)
    }

    it("should determine if -1 is a prime number") {
      P31.isPrime(-1) should be(false)
    }

    it("should determine if 2 is a prime number") {
      P31.isPrime(2) should be(true)
    }

    it("should determine if 11 is a prime number") {
      P31.isPrime(11) should be(true)
    }

    it("should determine if 10 is a prime number") {
      P31.isPrime(10) should be(false)
    }
  }

}
