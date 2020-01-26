package binary_trees_4

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class P60Test extends AnyFunSpec with Matchers {

  describe("P60 - minHbalNodes") {
    it("should return 4 nodes in height-balanced binary tree given height = 3") {
      P60.minHbalNodes(3) should be(4)
    }

    it("should return 33 nodes in height-balanced binary tree given height = 7") {
      P60.minHbalNodes(7) should be(33)
    }
  }

  describe("P60 - maxHbalNodes") {
    it("should return 4 nodes in height-balanced binary tree given height = 3") {
      P60.maxHbalNodes(3) should be(7)
    }

    it("should return 33 nodes in height-balanced binary tree given height = 7") {
      P60.maxHbalNodes(7) should be(127)
    }
  }

  describe("P60 - maxHbalHeight") {
    it("should return 4 height in height-balanced binary tree given 12 nodes") {
      P60.maxHbalHeight(12) should be(4)
    }
  }

}
