package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts}

class FourOfAKindSpec extends PokerHandSpec {
  "Four of a kind hand" should "consist of five cards" in {
    aFourOfAKind.cards.size should be(5)

    FourOfAKind(Seq(Card(Hearts, "Two", 2), Card(Clubs, "Two", 3), Card(Diamonds, "Two", 2))) shouldBe None
    FourOfAKind(Seq()) shouldBe None
  }

  "it" should "consist of four cards with the same value" in {
    val groupBy = aFourOfAKind.cards.groupBy(_.value)

    groupBy(2).size should be(4)
    groupBy(3).size should be(1)

    FourOfAKind(Seq(Card(Hearts, "Two", 2), Card(Clubs, "Two", 2), Card(Diamonds, "Two", 2), Card(Hearts, "Five", 5),
      Card(Hearts, "Six", 6))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aFourOfAKind.rank(aHighCard) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    aFourOfAKind.rank(aTwoPairs) should be > 0
  }

  "it" should "rank higher than a two pairs hand" in {
    aFourOfAKind.rank(aTwoPairs) should be > 0
  }

  "it" should "rank higher than a three of a kind hand" in {
    aFourOfAKind.rank(aThreeOfAKind) should be > 0
  }

  "it" should "rank higher than a straight card hand" in {
    aFourOfAKind.rank(aStraight) should be > 0
  }

  "it" should "rank higher than a flush hand" in {
    aFourOfAKind.rank(aFlush) should be > 0
  }

  "it" should "rank higher than a full house hand" in {
    aFourOfAKind.rank(aFullHouse) should be > 0
  }

  "it" should "rank lower than a straight flush hand" in {
    aFourOfAKind.rank(aStraightFlush) should be < 0
  }
}
