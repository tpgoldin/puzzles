package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class TwoPairsSpec extends AnyFlatSpec with should.Matchers {
  val twoPairs = TwoPairs(Seq())

  "Two pairs hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    twoPairs.rank(value) should be > 0
  }
}
