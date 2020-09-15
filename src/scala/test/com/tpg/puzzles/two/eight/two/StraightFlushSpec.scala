package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StraightFlushSpec extends AnyFlatSpec with should.Matchers {
  val straightFlush = StraightFlush(Seq())

  "Flush hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    straightFlush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    straightFlush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a two pairs hand" in {
    val value = TwoPairs(Seq())

    straightFlush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a three of a kind hand" in {
    val value = ThreeOfAKind(Seq())

    straightFlush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a straight hand" in {
    val value = Straight(Seq())

    straightFlush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a flush hand" in {
    val value = Flush(Seq())

    straightFlush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a full house hand" in {
    val value = FullHouse(Seq())

    straightFlush.rank(value) should be > 0
  }

  "Flush hand" should "rank higher than a four of a kind hand" in {
    val value = FourOfAKind(Seq())

    straightFlush.rank(value) should be > 0
  }
}
