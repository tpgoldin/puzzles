package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class FullHouseSpec extends AnyFlatSpec with should.Matchers {
  val fullHouse = FullHouse(Seq())

  "Full house hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    fullHouse.rank(value) should be > 0
  }

  "Full house hand" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    fullHouse.rank(value) should be > 0
  }

  "Full house hand" should "rank higher than a two pairs hand" in {
    val value = TwoPairs(Seq())

    fullHouse.rank(value) should be > 0
  }

  "Full house hand" should "rank higher than a three of a kind hand" in {
    val value = ThreeOfAKind(Seq())

    fullHouse.rank(value) should be > 0
  }

  "Full house hand" should "rank higher than a straight hand" in {
    val value = Straight(Seq())

    fullHouse.rank(value) should be > 0
  }

  "Full house hand" should "rank higher than a flush hand" in {
    val value = Flush(Seq())

    fullHouse.rank(value) should be > 0
  }

  "Full house hand" should "rank lower than a four of a kind hand" in {
    val value = FourOfAKind(Seq())

    fullHouse.rank(value) should be < 0
  }

  "Full house hand" should "rank lower than a straight flush hand" in {
    val value = StraightFlush(Seq())

    fullHouse.rank(value) should be < 0
  }
}
