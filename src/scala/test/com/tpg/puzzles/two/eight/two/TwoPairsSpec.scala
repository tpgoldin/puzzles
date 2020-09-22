package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Eight, Five, Four, Nine, Queen, Seven, Ten, Three, Two}
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts}

class TwoPairsSpec extends PokerHandSpec {
  "Two pairs hand" should "consist of five cards" in {
    aTwoPairs.cards.size should be (5)

    TwoPairs(Seq(Card(Hearts, Five), Card(Diamonds, Seven))) shouldBe None
    TwoPairs(Seq()) shouldBe None
  }

  "it" should "consist of two pairs of cards of the same value" in {
    val groupBy = aTwoPairs.cards.groupBy(_.value)

    Seq(2, 7).foreach(groupBy(_).size should be(2))

    TwoPairs(Seq(Hearts, Diamonds).map(Card(_, Three)) ++
      Seq(Card(Diamonds, Four), Card(Clubs, Eight), Card(Clubs, Nine))) shouldBe None
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

  "it" should "rank equal when the values are the same" in {
    aTwoPairs.rank(aTwoPairs) should be(0)
  }

  "it" should "rank higher when ranked by the value of their highest pair" in {
    val aTwoPairs1 = TwoPairs(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Clubs, Diamonds).map(Card(_, Seven)) ++
      Seq(Card(Hearts, Queen))).head

    val aTwoPairs2 = TwoPairs(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Clubs, Diamonds).map(Card(_, Eight)) ++
      Seq(Card(Hearts, Queen))).head

    aTwoPairs2.rank(aTwoPairs1) should be > 0
    aTwoPairs1.rank(aTwoPairs2) should be < 0
  }

  "it" should "rank higher when ranked by the value of the second pair" in {
    val aTwoPairs1 = TwoPairs(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Clubs, Diamonds).map(Card(_, Seven)) ++
      Seq(Card(Hearts, Queen))).head

    val aTwoPairs2 = TwoPairs(Seq(Hearts, Diamonds).map(Card(_, Three)) ++ Seq(Clubs, Diamonds).map(Card(_, Seven)) ++
      Seq(Card(Hearts, Queen))).head

    aTwoPairs2.rank(aTwoPairs1) should be > 0
    aTwoPairs1.rank(aTwoPairs2) should be < 0
  }

  "it" should "rank higher when ranked by the value of the single value" in {
    val aTwoPairs1 = TwoPairs(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Clubs, Diamonds).map(Card(_, Seven)) ++
      Seq(Card(Hearts, Ten))).head

    val aTwoPairs2 = TwoPairs(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Clubs, Diamonds).map(Card(_, Seven)) ++
      Seq(Card(Hearts, Queen))).head

    aTwoPairs2.rank(aTwoPairs1) should be > 0
    aTwoPairs1.rank(aTwoPairs2) should be < 0
  }
}
