package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StraightSpec extends AnyFlatSpec with should.Matchers {
  val straight = Straight(Seq())

  "Straight hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    straight.rank(value) should be > 0
  }

  "Straight hand" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    straight.rank(value) should be > 0
  }

  "Straight hand" should "rank higher than a two pairs hand" in {
    val value = TwoPairs(Seq())

    straight.rank(value) should be > 0
  }

  "Straight hand" should "rank higher than a three of a kind hand" in {
    val value = ThreeOfAKind(Seq())

    straight.rank(value) should be > 0
  }
  
  "Straight hand" should "rank lower than a flush card hand" in {
    val value = Flush(Seq())

    straight.rank(value) should be < 0
  }

  "Straight hand" should "rank lower than a full house card hand" in {
    val value = FullHouse(Seq())

    straight.rank(value) should be < 0
  }

  "Straight hand" should "rank lower than a four of a kind card hand" in {
    val value = FourOfAKind(Seq())

    straight.rank(value) should be < 0
  }

  "Straight hand" should "rank lower than a straight flush card hand" in {
    val value = StraightFlush(Seq())

    straight.rank(value) should be < 0
  }
}
