package arithmetic_2

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P41Test extends AnyFunSpec with Matchers {

  describe("P41") {
    it("A list of Goldbach compositions in range (9 to 20)") {
      P41.printGoldbachList(9 to 20) should be(List((10, (3, 7)), (12, (5, 7)), (14, (3, 11)), (16, (3, 13)), (18, (5, 13)), (20, (3, 17))))
    }

    it("A list of Goldbach compositions in range (1 to 10)") {
      P41.printGoldbachList(1 to 10) should be(List((4, (2, 2)), (6, (3, 3)), (8, (3, 5)), (10, (3, 7))))
    }
  }

}
