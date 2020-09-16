package com.tpg.puzzles.two.eight.two

class TwoPairsSpec extends PokerHandSpec {
  "Two pairs hand" should "consist of five cards" in {
    
  }

  "it" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    aTwoPairs.rank(value) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    aTwoPairs.rank(value) should be > 0
  }

  "it" should "rank lower than a three of a kind card hand" in {
    aTwoPairs.rank(aThreeOfAKind) should be < 0
  }

  "it" should "rank lower than a straight card hand" in {
    aTwoPairs.rank(aStraight) should be < 0
  }

  "it" should "rank lower than a flush card hand" in {
    aTwoPairs.rank(aFlush) should be < 0
  }

  "it" should "rank lower than a full house card hand" in {
    aTwoPairs.rank(aFullHouse) should be < 0
  }

  "it" should "rank lower than a four of a kind card hand" in {
    aTwoPairs.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a straight flush card hand" in {
    aTwoPairs.rank(aStraightFlush) should be < 0
  }
}
