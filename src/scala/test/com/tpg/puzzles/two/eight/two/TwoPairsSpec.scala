package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class TwoPairsSpec extends PokerHandSpec {
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
    twoPairs.rank(aStraight) should be < 0
  }

  "Two pairs hand" should "rank lower than a flush card hand" in {
    twoPairs.rank(aFlush) should be < 0
  }

  "Two pairs hand" should "rank lower than a full house card hand" in {
    twoPairs.rank(aFullHouse) should be < 0
  }

  "Two pairs hand" should "rank lower than a four of a kind card hand" in {
    twoPairs.rank(aFourOfAKind) should be < 0
  }

  "Two pairs hand" should "rank lower than a straight flush card hand" in {
    twoPairs.rank(aStraightFlush) should be < 0
  }
}
