package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PairSpec extends AnyFlatSpec with should.Matchers {
  val pair = Pair(Seq())

  "Pair hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    pair.rank(value) should be > 0
  }

  "Pair hand" should "rank lower than a two pairs hand" in {
    val value = TwoPairs(Seq())

    pair.rank(value) should be < 0
  }

  "Pair hand" should "rank lower than a three of a kind hand" in {
    val value = ThreeOfAKind(Seq())

    pair.rank(value) should be < 0
  }

  "Pair hand" should "rank lower than a straight hand" in {
    val value = Straight(Seq())

    pair.rank(value) should be < 0
  }

  "Pair hand" should "rank lower than a flush hand" in {
    val value = Flush(Seq())

    pair.rank(value) should be < 0
  }

  "Pair hand" should "rank lower than a full house hand" in {
    val value = FullHouse(Seq())

    pair.rank(value) should be < 0
  }

  "Pair hand" should "rank lower than a four of a kind hand" in {
    val value = FourOfAKind(Seq())

    pair.rank(value) should be < 0
  }

  "Pair hand" should "rank lower than a straight flush hand" in {
    val value = StraightFlush(Seq())

    pair.rank(value) should be < 0
  }
}
