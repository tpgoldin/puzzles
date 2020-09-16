package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts}

class StraightSpec extends PokerHandSpec {
  "Straight" should "consist of five cards" in {
    aStraight.cards.size should be(5)

    Straight(Seq(Card(Hearts, "Six", 6), Card(Hearts, "Seven", 7))) shouldBe None
    Straight(Seq()) shouldBe None
  }

  "it" should "consist of cards with consecutive values" in {

    val values = aStraight.cards.map(_.value)

    val min = values.min
    val max = values.max

    val range = min to max
    range.forall(i => range.contains(i)) should be(true)

    Straight(Seq(Card(Diamonds, "Three", 3), Card(Hearts, "Four", 4), Card(Hearts, "Six", 6), Card(Hearts, "Seven", 7), Card(Clubs, "Ten", 10))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    aStraight.rank(value) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    val value = Pair(Seq())

    aStraight.rank(value) should be > 0
  }

  "it" should "rank higher than a two pairs hand" in {
    val value = TwoPairs(Seq())

    aStraight.rank(value) should be > 0
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
}
