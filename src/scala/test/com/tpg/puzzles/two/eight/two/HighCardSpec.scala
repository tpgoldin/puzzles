package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.King
import com.tpg.puzzles.two.eight.two.Suit.Hearts

class HighCardSpec extends PokerHandSpec {
  "High card" should "consist of five cards" in {
    aHighCard.cards.size should be(5)

    HighCard(Seq(Card(Hearts, King))) shouldBe None
    HighCard(Seq()) shouldBe None
  }

  "it" should "not match any of the other hand types" in {
    Seq(aPair, aTwoPairs, aThreeOfAKind, aStraight, aFlush, aFullHouse, aFourOfAKind, aStraightFlush)
      .foreach(aHighCard should not equal _)
  }

  "it" should "rank lower than a pair hand" in {
    aHighCard.rank(aPair) should be < 0
  }

  "it" should "rank lower than a two pair hand" in {
    aHighCard.rank(aTwoPairs) should be < 0
  }

  "it" should "rank lower than a three of a kind hand" in {
    aHighCard.rank(aThreeOfAKind) should be < 0
  }

  "it" should "rank lower than a straight hand" in {
    aHighCard.rank(aStraight) should be < 0
  }

  "it" should "rank lower than a flush hand" in {
    aHighCard.rank(aFlush) should be < 0
  }

  "it" should "rank lower than a full house hand" in {
    aHighCard.rank(aFullHouse) should be < 0
  }

  "it" should "rank lower than a four of a kind hand" in {
    aHighCard.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a straight flush hand" in {
    aHighCard.rank(aStraightFlush) should be < 0
  }
}
