package com.tpg.puzzles.two.eight.two

class HighCardSpec extends PokerHandSpec {
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
    highCard.rank(aStraight) should be < 0
  }

  "High hand" should "rank lower than a flush hand" in {
    highCard.rank(aFlush) should be < 0
  }

  "High hand" should "rank lower than a full house hand" in {
    highCard.rank(aFullHouse) should be < 0
  }

  "High hand" should "rank lower than a four of a kind hand" in {
    highCard.rank(aFourOfAKind) should be < 0
  }

  "High hand" should "rank lower than a straight flush hand" in {
    highCard.rank(aStraightFlush) should be < 0
  }
}
