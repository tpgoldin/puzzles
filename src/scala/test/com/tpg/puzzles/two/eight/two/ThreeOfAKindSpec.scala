package com.tpg.puzzles.two.eight.two

class ThreeOfAKindSpec extends PokerHandSpec {
  val threeOfAKind = ThreeOfAKind(Seq())

  "Three of a kind hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    threeOfAKind.rank(value) should be > 0
  }

  "Three of a kind hand" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    threeOfAKind.rank(value) should be > 0
  }

  "Three of a kind hand" should "rank higher than a two pairs hand" in {
    val value = TwoPairs(Seq())

    threeOfAKind.rank(value) should be > 0
  }

  "Three of a kind hand" should "rank lower than a straight card hand" in {
    threeOfAKind.rank(aStraight) should be < 0
  }

  "Three of a kind hand" should "rank lower than a flush card hand" in {
    threeOfAKind.rank(aFlush) should be < 0
  }

  "Three of a kind hand" should "rank lower than a full house card hand" in {
    threeOfAKind.rank(aFullHouse) should be < 0
  }

  "Three of a kind hand" should "rank lower than a four of a kind card hand" in {
    threeOfAKind.rank(aFourOfAKind) should be < 0
  }

  "Three of a kind hand" should "rank lower than a straight flush card hand" in {
    threeOfAKind.rank(aStraightFlush) should be < 0
  }
}
