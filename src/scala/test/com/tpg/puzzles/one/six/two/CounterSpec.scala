package com.tpg.puzzles.one.six.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CounterSpec extends AnyFlatSpec with should.Matchers {
  val grid = new Grid(Seq("*..*", ".*..", "*..."))

  "Counter" should "count the number of asterisks in the neighbourhood of a point" in {
    val counter = new Counter(grid)
    counter((1, 0)) should be(3)
  }
}
