package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Suit.{Diamonds, Hearts}

class StraightFlushSpec extends PokerHandSpec {

  "Straight flush hand" should "consist of five cards" in {
    aStraightFlush.cards.size should be(5)

    StraightFlush(Seq(Card(Hearts, "Two", 2), Card(Hearts, "Three", 3), Card(Hearts, "Four", 4))) shouldBe None
    StraightFlush(Seq()) shouldBe None
  }

  "it" should "consist of cards of the same suit" in {
    aStraightFlush.cards.forall(_.suit == Hearts)

    val notStraightFlush = StraightFlush(Seq(Card(Hearts, "Two", 2), Card(Diamonds, "Three", 3), Card(Hearts, "Four", 4),
      Card(Hearts, "Five", 5), Card(Hearts, "Six", 6)))

    notStraightFlush shouldBe None
  }

  "it" should "consist of cards of consecutive values" in {

    val range = 2 to 6

    val cards = pack.cards(Hearts)

    val selectedCards = for (card <- cards if (range.contains(card.value))) yield card

    aStraightFlush.cards shouldBe selectedCards.sortBy(_.value)

    val notStraightFlush = StraightFlush(Seq(Card(Hearts, "Two", 2), Card(Hearts, "Nine", 9), Card(Hearts, "Four", 4),
      Card(Hearts, "Five", 5), Card(Hearts, "Six", 6)))

    notStraightFlush shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    aStraightFlush.rank(value) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    aStraightFlush.rank(value) should be > 0
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

  "it" should "rank another straight flush hand of higher rank " +
    "by the value of the highest card in the hand " in {

  }
}
