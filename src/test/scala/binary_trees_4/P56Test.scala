package binary_trees_4

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P56Test extends AnyFunSpec with Matchers {

  describe("P56") {
    it("should return true for this symmetric binary trees") {
      Node('a', Node('b'), Node('c')).isSymmetric should be(true)
    }

    it("should return false for this no symmetric binary trees") {
      Node('a', Node('b'), End).isSymmetric should be(false)
    }
  }

}


