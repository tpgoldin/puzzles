package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Ace, Eight, Nine, Queen, Seven, Ten, Three, Two}
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts}

class PairSpec extends PokerHandSpec {
  "Pair" should "consist of five cards" in {
    aPair.cards.size should be(5)

    Pair(Seq(Card(Diamonds, Ten), Card(Diamonds, Ace))) shouldBe None
    Pair(Seq()) shouldBe None
  }

  "it" should "consist of a single pair of cards with the same value" in {
    val groupBy = aPair.cards.groupBy(_.value)

    groupBy.count(_._2.size == 2) should be(1)
    groupBy(2) should equal (Seq(Hearts, Diamonds).map(Card(_, Two)))

    groupBy.count(_._2.size == 1) should be(3)

    Pair(aHighCard.cards) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aPair.rank(aHighCard) should be > 0
  }

  "it" should "rank lower than a two pairs hand" in {
    aPair.rank(aTwoPairs) should be < 0
  }

  "it" should "rank lower than a three of a kind hand" in {
    aPair.rank(aThreeOfAKind) should be < 0
  }

  "it" should "rank lower than a straight hand" in {
    aPair.rank(aStraight) should be < 0
  }

  "it" should "rank lower than a flush hand" in {
    aPair.rank(aFlush) should be < 0
  }

  "it" should "rank lower than a full house hand" in {
    aPair.rank(aFullHouse) should be < 0
  }

  "it" should "rank lower than a four of a kind hand" in {
    aPair.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a straight flush hand" in {
    aPair.rank(aStraightFlush) should be < 0
  }

  "it" should "rank greater than with pair with highest value" in {
    val aPair1 = Pair(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Seven, Eight).map(Card(Clubs, _)) ++
      Seq(Card(Hearts, Queen))).head

    val aPair2 = Pair(Seq(Hearts, Diamonds).map(Card(_, Three)) ++ Seq(Seven, Eight).map(Card(Clubs, _)) ++
      Seq(Card(Hearts, Queen))).head

    aPair2.rank(aPair1) should be > 0
    aPair1.rank(aPair2) should be < 0
  }

  "it" should "rank greater than when pair with highest value are the same and the next highest value in the remaining card values" in {
    val aPair1 = Pair(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Seven, Eight).map(Card(Clubs, _)) ++
      Seq(Card(Hearts, Queen))).head

    val aPair2 = Pair(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Eight, Nine).map(Card(Clubs, _)) ++
      Seq(Card(Hearts, Queen))).head

    aPair2.rank(aPair1) should be > 0
    aPair1.rank(aPair2) should be < 0
  }

  "it" should "rank equal when values are the same" in {
    aPair.rank(aPair) should be(0)
  }
}
