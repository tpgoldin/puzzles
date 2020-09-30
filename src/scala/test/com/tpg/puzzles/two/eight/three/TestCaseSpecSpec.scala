package com.tpg.puzzles.two.eight.three

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class TestCaseSpecSpec extends AnyFlatSpec with should.Matchers {
  "Test case spec" should "match number of parties with number of hartal parameters" in {
    TestCaseSpec(14, 3, List(3, 4, 8)).get should have (
      'N(14),
      'P(3),
      'hps(List(3, 4, 8)))
  }

  "it" should "not create a spec if the number of parties does not match the number of hartal parameters" in {
    TestCaseSpec(14, 2, List(3, 4, 8)) shouldBe None
  }
}
