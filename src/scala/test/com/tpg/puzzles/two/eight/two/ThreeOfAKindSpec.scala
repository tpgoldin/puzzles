package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ThreeOfAKindSpec extends AnyFlatSpec with should.Matchers {
  val threeOfAKind = ThreeOfAKind(Seq())

  "Three of a kind hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    threeOfAKind.rank(value) should be > 0
  }

  "Three of a kind hand" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    threeOfAKind.rank(value) should be > 0
  }

  "Three of a kind hand" should "rank higher than a two pairs hand" in {
    val value = TwoPairs(Seq())

    threeOfAKind.rank(value) should be > 0
  }

  "Three of a kind hand" should "rank lower than a straight card hand" in {
    val value = Straight(Seq())

    threeOfAKind.rank(value) should be < 0
  }

  "Three of a kind hand" should "rank lower than a flush card hand" in {
    val value = Flush(Seq())

    threeOfAKind.rank(value) should be < 0
  }

  "Three of a kind hand" should "rank lower than a full house card hand" in {
    val value = FullHouse(Seq())

    threeOfAKind.rank(value) should be < 0
  }

  "Three of a kind hand" should "rank lower than a four of a kind card hand" in {
    val value = FourOfAKind(Seq())

    threeOfAKind.rank(value) should be < 0
  }

  "Three of a kind hand" should "rank lower than a straight flush card hand" in {
    val value = StraightFlush(Seq())

    threeOfAKind.rank(value) should be < 0
  }
}
