package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Spades}

class FlushSpec extends PokerHandSpec {

  "Flush hand" should "consist of five cards" in {
    aFlush.cards.size should be(5)

    Flush(Seq(Card(Spades, "Four", 4), Card(Clubs, "Queen", 12))) shouldBe None
    Flush(Seq()) shouldBe None
  }

  "it" should "consist of cards of the same suit" in {
    val groupBy = aFlush.cards.groupBy(_.suit)

    groupBy.size should be (1)
    groupBy(Diamonds).size should be (5)

    Flush(Seq(Card(Spades, "Four", 4), Card(Clubs, "Two", 2), Card(Clubs, "Five", 5), Card(Clubs, "Jack", 11), Card(Clubs, "Queen", 12))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aFlush.rank(aHighCard) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    aFlush.rank(aPair) should be > 0
  }

  "it" should "rank higher than a two pairs hand" in {
    aFlush.rank(aTwoPairs) should be > 0
  }

  "it" should "rank higher than a three of a kind hand" in {
    aFlush.rank(aThreeOfAKind) should be > 0
  }

  "it" should "rank higher than a straight hand" in {
    aFlush.rank(aStraight) should be > 0
  }

  "it" should "rank lower than a full house hand" in {
    aFlush.rank(aFullHouse) should be < 0
  }

  "it" should "rank lower than a four of a kind hand" in {
    aFlush.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a straight aFlush hand" in {
    aFlush.rank(aStraightFlush) should be < 0
  }
}
