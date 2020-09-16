package com.tpg.puzzles.two.eight.two

class PairSpec extends PokerHandSpec {
  val pair = Pair(Seq())

  "Pair hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    pair.rank(value) should be > 0
  }

  "it" should "rank lower than a two pairs hand" in {
    pair.rank(aTwoPairs) should be < 0
  }

  "it" should "rank lower than a three of a kind hand" in {
    pair.rank(aThreeOfAKind) should be < 0
  }

  "it" should "rank lower than a straight hand" in {
    pair.rank(aStraight) should be < 0
  }

  "it" should "rank lower than a flush hand" in {
    pair.rank(aFlush) should be < 0
  }

  "it" should "rank lower than a full house hand" in {
    pair.rank(aFullHouse) should be < 0
  }

  "it" should "rank lower than a four of a kind hand" in {
    pair.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a straight flush hand" in {
    pair.rank(aStraightFlush) should be < 0
  }
}
