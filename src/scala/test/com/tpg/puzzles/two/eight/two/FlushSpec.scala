package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class FlushSpec extends AnyFlatSpec with should.Matchers {
  val flush = Flush(Seq())

  "Flush hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    flush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    flush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a two pairs hand" in {
    val value = TwoPairs(Seq())

    flush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a three of a kind hand" in {
    val value = ThreeOfAKind(Seq())

    flush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a straight hand" in {
    val value = Straight(Seq())

    flush.rank(value) should be > 0
  }

  "Flush hand" should "rank lower than a full house hand" in {
    val value = FullHouse(Seq())

    flush.rank(value) should be < 0
  }

  "Flush hand" should "rank lower than a four of a kind hand" in {
    val value = FourOfAKind(Seq())

    flush.rank(value) should be < 0
  }

  "Flush hand" should "rank lower than a straight flush hand" in {
    val value = StraightFlush(Seq())

    flush.rank(value) should be < 0
  }
}
