package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class TwoPairsSpec extends AnyFlatSpec with should.Matchers {
  val twoPairs = TwoPairs(Seq())

  "Two pairs hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    twoPairs.rank(value) should be > 0
  }

  "Two pairs hand" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    twoPairs.rank(value) should be > 0
  }

  "Two pairs hand" should "rank lower than a three of a kind card hand" in {
    val value = ThreeOfAKind(Seq())

    twoPairs.rank(value) should be < 0
  }

  "Two pairs hand" should "rank lower than a straight card hand" in {
    val value = Straight(Seq())

    twoPairs.rank(value) should be < 0
  }

  "Two pairs hand" should "rank lower than a flush card hand" in {
    val value = Flush(Seq())

    twoPairs.rank(value) should be < 0
  }

  "Two pairs hand" should "rank lower than a full house card hand" in {
    val value = FullHouse(Seq())

    twoPairs.rank(value) should be < 0
  }

  "Two pairs hand" should "rank lower than a four of a kind card hand" in {
    val value = FourOfAKind(Seq())

    twoPairs.rank(value) should be < 0
  }

  "Two pairs hand" should "rank lower than a straight flush card hand" in {
    val value = StraightFlush(Seq())

    twoPairs.rank(value) should be < 0
  }
}
