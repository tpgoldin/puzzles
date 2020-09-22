package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Eight, Five, Four, Jack, Nine, Seven, Ten, Three}
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts}

class ThreeOfAKindSpec extends PokerHandSpec {
  "Three of a kind" should "consist of five cards" in {
    aThreeOfAKind.cards.size should be (5)

    ThreeOfAKind(Seq(Card(Hearts, Three))) shouldBe None
    ThreeOfAKind(Seq()) shouldBe None
  }

  "it" should "consist of three cards in the hand having the same value" in {
    val groupBy = aThreeOfAKind.cards.groupBy(_.value)

    val aList = groupBy.map(_._2.size).toList

    aList.contains(3) should be (true)

    ThreeOfAKind(Seq(Hearts, Diamonds).map(Card(_, Ten)) ++ Seq(Card(Clubs, Jack), Card(Diamonds, Four), Card(Diamonds, Five))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aThreeOfAKind.rank(aHighCard) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    aThreeOfAKind.rank(aPair) should be > 0
  }

  "it" should "rank higher than a two pairs hand" in {
    aThreeOfAKind.rank(aTwoPairs) should be > 0
  }

  "it" should "rank lower than a straight card hand" in {
    aThreeOfAKind.rank(aStraight) should be < 0
  }

  "it" should "rank lower than a flush card hand" in {
    aThreeOfAKind.rank(aFlush) should be < 0
  }

  "it" should "rank lower than a full house card hand" in {
    aThreeOfAKind.rank(aFullHouse) should be < 0
  }

  "it" should "rank lower than a four of a kind card hand" in {
    aThreeOfAKind.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a straight flush card hand" in {
    aThreeOfAKind.rank(aStraightFlush) should be < 0
  }

  "it" should "rank equal if the hands are the same" in {
    aThreeOfAKind.rank(aThreeOfAKind) should be (0)
  }

  "it" should "rank higher if three of a kind value is greater" in {
    val aThreeOfAKind1 = ThreeOfAKind(Seq(Hearts, Diamonds, Clubs).map(Card(_, Five)) ++
      Seq(Card(Hearts, Seven), Card(Diamonds, Nine))).head

    val aThreeOfAKind2 = ThreeOfAKind(Seq(Hearts, Diamonds, Clubs).map(Card(_, Eight)) ++
      Seq(Card(Hearts, Seven), Card(Diamonds, Nine))).head

    aThreeOfAKind2.rank(aThreeOfAKind1) should be > 0
    aThreeOfAKind1.rank(aThreeOfAKind2) should be < 0
  }

  "it" should "rank equal if three of a kind values are the same" in {
    val aThreeOfAKind1 = ThreeOfAKind(Seq(Hearts, Diamonds, Clubs).map(Card(_, Five)) ++
      Seq(Card(Hearts, Seven), Card(Diamonds, Nine))).head

    val aThreeOfAKind2 = ThreeOfAKind(Seq(Hearts, Diamonds, Clubs).map(Card(_, Five)) ++
      Seq(Card(Hearts, Seven), Card(Diamonds, Eight))).head

    aThreeOfAKind2.rank(aThreeOfAKind1) should be(0)
    aThreeOfAKind1.rank(aThreeOfAKind2) should be(0)
  }
}
