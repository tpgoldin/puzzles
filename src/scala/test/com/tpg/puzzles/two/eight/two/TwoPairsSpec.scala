package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts}

class TwoPairsSpec extends PokerHandSpec {
  "Two pairs hand" should "consist of five cards" in {
    aTwoPairs.cards.size should be (5)

    TwoPairs(Seq(Card(Hearts, "Five", 5), Card(Diamonds, "Seven", 7))) shouldBe None
    TwoPairs(Seq()) shouldBe None
  }

  "it" should "consist of two pairs of cards of the same value" in {
    val groupBy = aTwoPairs.cards.groupBy(_.value)

    Seq(2, 7).foreach(groupBy(_).size should be(2))

    val groupByAgain = TwoPairs(Seq(Hearts, Diamonds, Clubs).map(Card(_, "Three", 3)) ++
      Seq(Card(Diamonds, "Four", 4), Card(Clubs, "Four", 4))).head.cards.groupBy(_.value)

    groupByAgain(3) should equal (List(Hearts, Diamonds, Clubs).map(Card(_, "Three", 3)))
    groupByAgain(4) should equal (List(Diamonds, Clubs).map(Card(_, "Four", 4)))

    TwoPairs(Seq(Hearts, Diamonds).map(Card(_, "Three", 3)) ++
      Seq(Card(Diamonds, "Four", 4), Card(Clubs, "Eight", 8), Card(Clubs, "Nine", 9))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aTwoPairs.rank(aHighCard) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    aTwoPairs.rank(aPair) should be > 0
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
