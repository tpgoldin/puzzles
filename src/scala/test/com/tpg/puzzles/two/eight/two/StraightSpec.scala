package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Five, Four, Seven, Six, Ten, Three, Two}
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts}

class StraightSpec extends PokerHandSpec {
  "Straight" should "consist of five cards" in {
    aStraight.cards.size should be(5)

    Straight(Seq(Card(Hearts, Six), Card(Hearts, Seven))) shouldBe None
    Straight(Seq()) shouldBe None
  }

  "it" should "consist of cards with consecutive values" in {

    val values = aStraight.cards.map(_.value)

    val min = values.min
    val max = values.max

    val range = min to max
    range.forall(i => range.contains(i)) should be(true)

    Straight(Seq(Card(Diamonds, Three), Card(Hearts, Four), Card(Hearts, Six), Card(Hearts, Seven),
      Card(Clubs, Ten))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aStraight.rank(aHighCard) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    aStraight.rank(aPair) should be > 0
  }

  "it" should "rank higher than a two pairs hand" in {
    aStraight.rank(aTwoPairs) should be > 0
  }

  "it" should "rank higher than a three of a kind hand" in {
    aStraight.rank(aThreeOfAKind) should be > 0
  }
  
  "it" should "rank lower than a flush card hand" in {
    aStraight.rank(aFlush) should be < 0
  }

  "it" should "rank lower than a full house card hand" in {
    aStraight.rank(aFullHouse) should be < 0
  }

  "it" should "rank lower than a four of a kind card hand" in {
    aStraight.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a aStraight flush card hand" in {
    aStraight.rank(aStraightFlush) should be < 0
  }

  "it" should "rank equal when hands contain the same values" in {
    aStraight.rank(aStraight) should be(0)
  }

  "it" should "rank higher when the value is highest" in {
    val aStraight1 = Straight(Seq(Card(Diamonds, Two), Card(Hearts, Three), Card(Hearts, Four), Card(Clubs, Five), Card(Clubs, Six))).head

    val aStraight2 = Straight(Seq(Card(Hearts, Three), Card(Hearts, Four), Card(Clubs, Five), Card(Clubs, Six), Card(Clubs, Seven))).head

    aStraight2.rank(aStraight1) should be > 0
    aStraight1.rank(aStraight2) should be < 0
  }
}
