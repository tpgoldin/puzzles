package com.tpg.puzzles.one.six.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class GridSpec extends AnyFlatSpec with should.Matchers {
  val grid = new Grid(Seq("*..*", ".*..", "*..."))

  "Grid" should "construct an internal representation of the characters from the given lines" in {

    grid.size should be ((3, 4))

    grid.value should contain theSameElementsAs Seq((0, 0), (0, 3), (1, 1), (2, 0))
  }

  "Grid" should "be able to read the character at at given location from the lines given" in {
    // grid(0, 3) should be ('*')
  }
}
