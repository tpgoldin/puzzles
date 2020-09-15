package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class FourOfAKindSpec extends AnyFlatSpec with should.Matchers {
  val fourOfAKind = FourOfAKind(Seq())

  "Four of a kind hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    fourOfAKind.rank(value) should be > 0
  }
}
