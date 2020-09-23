package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Five, Four, Nine, Seven, Six, Three, Two}
import com.tpg.puzzles.two.eight.two.Suit.{Diamonds, Hearts}

class StraightFlushSpec extends PokerHandSpec {

  "Straight flush hand" should "consist of five cards" in {
    aStraightFlush.cards.size should be(5)

    StraightFlush(Seq(Card(Hearts, Two), Card(Hearts, Three), Card(Hearts, Four))) shouldBe None
    StraightFlush(Seq()) shouldBe None
  }

  "it" should "consist of cards of the same suit" in {
    aStraightFlush.cards.forall(_.suit == Hearts)

    val notStraightFlush = StraightFlush(Seq(Card(Hearts, Two), Card(Diamonds, Three), Card(Hearts, Four),
      Card(Hearts, Five), Card(Hearts, Six)))

    notStraightFlush shouldBe None
  }

  "it" should "consist of cards of consecutive values" in {

    val range = 2 to 6

    val cards = pack.cards(Hearts)

    val selectedCards = for (card <- cards if (range.contains(card.value))) yield card

    aStraightFlush.cards shouldBe selectedCards.sortBy(_.value)

    StraightFlush(Seq(Card(Hearts, Two), Card(Hearts, Nine), Card(Hearts, Four), Card(Hearts, Five),
      Card(Hearts, Six))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aStraightFlush.rank(aHighCard) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    aStraightFlush.rank(aPair) should be > 0
  }

  "it" should "rank higher than a two pairs hand" in {
    aStraightFlush.rank(aTwoPairs) should be > 0
  }

  "it" should "rank higher than a three of a kind hand" in {
    aStraightFlush.rank(aThreeOfAKind) should be > 0
  }

  "it" should "rank higher than a straight hand" in {
    aStraightFlush.rank(aStraight) should be > 0
  }

  "it" should "rank higher than a flush hand" in {
    aStraightFlush.rank(aFlush) should be > 0
  }

  "it" should "rank higher than a full house hand" in {
    aStraightFlush.rank(aFullHouse) should be > 0
  }

  "it" should "rank higher than a four of a kind hand" in {
    aStraightFlush.rank(aFourOfAKind) should be > 0
  }

  "it" should "rank equal to the same hand" in {
    aStraightFlush.rank(aStraightFlush) should be(0)
  }

  "it" should "rank another straight flush hand of higher rank " +
    "by the value of the highest card in the hand " in {

    val aStraightFlush1 = StraightFlush(Seq(Two, Three, Four, Five, Six).map(Card(Hearts, _))).head
    val aStraightFlush2 = StraightFlush(Seq(Three, Four, Five, Six, Seven).map(Card(Diamonds, _))).head

    aStraightFlush2.rank(aStraightFlush1) should be > 0
    aStraightFlush1.rank(aStraightFlush2) should be < 0
  }
}
