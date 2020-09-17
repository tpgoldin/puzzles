package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Eight, Four, Six, Two}
import com.tpg.puzzles.two.eight.two.Suit.{Diamonds, Hearts}

class FullHouseSpec extends PokerHandSpec {

  "Full house hand" should "consist of five cards" in {
    aFullHouse.cards.size should be (5)

    FullHouse(Seq()) shouldBe None
    FullHouse(Seq(Card(Hearts, Two))) shouldBe None
  }

  "it" should "consist of three cards of the same value and another pair of cards of a different value" in {
    val groupBy = aFullHouse.cards.groupBy(_.value)

    groupBy(5).size should be(3)
    groupBy(6).size should be(2)

    FullHouse(Seq(Card(Hearts, Two), Card(Diamonds, Two), Card(Hearts, Four), Card(Hearts, Six),
      Card(Hearts, Eight))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aFullHouse.rank(aHighCard) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    aFullHouse.rank(aPair) should be > 0
  }

  "it" should "rank higher than a two pairs hand" in {
    aFullHouse.rank(aTwoPairs) should be > 0
  }

  "it" should "rank higher than a three of a kind hand" in {
    aFullHouse.rank(aThreeOfAKind) should be > 0
  }

  "it" should "rank higher than a straight hand" in {
    aFullHouse.rank(aStraight) should be > 0
  }

  "it" should "rank higher than a flush hand" in {
    aFullHouse.rank(aFlush) should be > 0
  }

  "it" should "rank lower than a four of a kind hand" in {
    aFullHouse.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a straight flush hand" in {
    aFullHouse.rank(aStraightFlush) should be < 0
  }
}
