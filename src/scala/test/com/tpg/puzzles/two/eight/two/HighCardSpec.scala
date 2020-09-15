package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class HighCardSpec extends AnyFlatSpec with should.Matchers {
  val highCard = HighCard(Seq())

  "High hand" should "rank lower than a pair hand" in {
    val value = Pair(Seq())

    highCard.rank(value) should be < 0
  }

  "High hand" should "rank lower than a two pair hand" in {
    val value = TwoPairs(Seq())

    highCard.rank(value) should be < 0
  }

  "High hand" should "rank lower than a three of a kind hand" in {
    val value = ThreeOfAKind(Seq())

    highCard.rank(value) should be < 0
  }

  "High hand" should "rank lower than a straight hand" in {
    val value = Straight(Seq())

    highCard.rank(value) should be < 0
  }
}
