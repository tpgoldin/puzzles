package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Eight, Five, Four, Jack, Queen, Seven, Six, Two}
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts, Spades}

class FlushSpec extends PokerHandSpec {

  "Flush hand" should "consist of five cards" in {
    aFlush.cards.size should be(5)

    Flush(Seq(Card(Spades, Four), Card(Clubs, Queen))) shouldBe None
    Flush(Seq()) shouldBe None
  }

  "it" should "consist of cards of the same suit" in {
    val groupBy = aFlush.cards.groupBy(_.suit)

    groupBy.size should be (1)
    groupBy(Diamonds).size should be (5)

    Flush(Seq(Card(Spades, Four), Card(Clubs, Two), Card(Clubs, Five), Card(Clubs, Jack), Card(Clubs, Queen))) shouldBe None
  }

  "it" should "rank higher than a high card hand" in {
    aFlush.rank(aHighCard) should be > 0
  }

  "it" should "rank higher than a pair hand" in {
    aFlush.rank(aPair) should be > 0
  }

  "it" should "rank higher than a two pairs hand" in {
    aFlush.rank(aTwoPairs) should be > 0
  }

  "it" should "rank higher than a three of a kind hand" in {
    aFlush.rank(aThreeOfAKind) should be > 0
  }

  "it" should "rank higher than a straight hand" in {
    aFlush.rank(aStraight) should be > 0
  }

  "it" should "rank lower than a full house hand" in {
    aFlush.rank(aFullHouse) should be < 0
  }

  "it" should "rank lower than a four of a kind hand" in {
    aFlush.rank(aFourOfAKind) should be < 0
  }

  "it" should "rank lower than a straight aFlush hand" in {
    aFlush.rank(aStraightFlush) should be < 0
  }

  "it" should "rank equal when the hands are the same" in {
    aFlush.rank(aFlush) should be (0)
  }

  "it" should "rank greater when the highest value is greater" in {
    val aFlush1 = Flush(Seq(Two, Five, Six, Eight, Jack).map(Card(Diamonds, _))).head

    val aFlush2 = Flush(Seq(Two, Five, Six, Eight, Queen).map(Card(Hearts, _))).head

    aFlush2.rank(aFlush1) should be > 0
    aFlush1.rank(aFlush2) should be < 0
  }

  "it" should "rank greater when the next highest value is greater" in {
    val aFlush1 = Flush(Seq(Two, Five, Six, Eight, Jack).map(Card(Diamonds, _))).head

    val aFlush2 = Flush(Seq(Two, Five, Seven, Eight, Jack).map(Card(Hearts, _))).head

    aFlush2.rank(aFlush1) should be > 0
    aFlush1.rank(aFlush2) should be < 0
  }
}
