package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel._
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts, Spades}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PokerHandBuildingSpec extends PokerHandSpec {
  "Poker hand applies" should "build straight flush hand when cards match straight flush spec" in {
    PokerHand(aStraightFlush.cards).get shouldBe a [StraightFlush]
  }

  "Poker hand applies" should "build four of a kind hand when cards match four of a kind spec" in {
    PokerHand(aFourOfAKind.cards).get shouldBe a [FourOfAKind]
  }

  "Poker hand applies" should "build full house hand when cards match full house spec" in {
    PokerHand(aFullHouse.cards).get shouldBe a [FullHouse]
  }

  "Poker hand applies" should "build flush hand when cards match flush spec" in {
    PokerHand(aFlush.cards).get shouldBe a [Flush]
  }

  "Poker hand applies" should "build straight hand when cards match straight spec" in {
    PokerHand(aStraight.cards).get shouldBe a [Straight]
  }

  "Poker hand applies" should "build three of a kind hand when cards match three of a kind spec" in {
    PokerHand(aThreeOfAKind.cards).get shouldBe a [ThreeOfAKind]
  }

  "Poker hand applies" should "build two pairs hand when cards match two pairs spec" in {
    PokerHand(aTwoPairs.cards).get shouldBe a [TwoPairs]
  }

  "Poker hand applies" should "build pair hand when cards match pair spec" in {
    PokerHand(aPair.cards).get shouldBe a [Pair]
  }

  "Poker hand applies" should "build high hand when cards do not match any other poker hand spec" in {
    PokerHand(aHighCard.cards).get shouldBe a [HighCard]
  }

  "Poker hand applies" should "build a poker hand from cards spec" in {
    PokerHand(Array("2H", "3D", "5S","9C", "KD")).get shouldBe a [PokerHand]
  }
}
