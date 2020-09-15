package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ThreeOfAKindSpec extends AnyFlatSpec with should.Matchers {
  val threeOfAKind = ThreeOfAKind(Seq())

  "Three of a kind hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    threeOfAKind.rank(value) should be > 0
  }
}
