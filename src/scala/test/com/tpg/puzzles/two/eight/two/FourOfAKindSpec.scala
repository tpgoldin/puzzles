package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class FourOfAKindSpec extends AnyFlatSpec with should.Matchers {
  val fourOfAKind = FourOfAKind(Seq())

  "Four of a kind hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    fourOfAKind.rank(value) should be > 0
  }

  "Four of a kind hand" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    fourOfAKind.rank(value) should be > 0
  }

  "Four of a kind hand" should "rank higher than a two pairs hand" in {
    val value = TwoPairs(Seq())

    fourOfAKind.rank(value) should be > 0
  }

  "Four of a kind hand" should "rank higher than a three of a kind hand" in {
    val value = ThreeOfAKind(Seq())

    fourOfAKind.rank(value) should be > 0
  }

  "Four of a kind hand" should "rank higher than a straight card hand" in {
    val value = Straight(Seq())

    fourOfAKind.rank(value) should be > 0
  }

  "Four of a kind hand" should "rank higher than a flush hand" in {
    val value = Flush(Seq())

    fourOfAKind.rank(value) should be > 0
  }

  "Four of a kind hand" should "rank higher than a full house hand" in {
    val value = FullHouse(Seq())

    fourOfAKind.rank(value) should be > 0
  }

  "Four of a kind hand" should "rank lower than a straight flush hand" in {
    val value = StraightFlush(Seq())

    fourOfAKind.rank(value) should be < 0
  }
}
