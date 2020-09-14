package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class HighCardSpec extends AnyFlatSpec with should.Matchers {
  val highCard = HighCard(Seq())

  "High card" should "rank lower than a pair hand" in {
    val pair = Pair(Seq())

    highCard.rank(pair) should be < 0
  }

  "High card" should "rank lower than a two pair hand" in {
    val pair = TwoPair(Seq())

    highCard.rank(pair) should be < 0
  }
}
