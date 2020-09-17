package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Eight, Five, Four, Jack, Six, Seven, Queen, Nine, Three, Two, Ten}
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts, Spades}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PokerHandSpec extends AnyFlatSpec with should.Matchers {
  val pack = PackOfCards()

  val aStraightFlush = StraightFlush(Seq(Two, Three, Four, Five, Six).map(Card(Hearts, _))).head

  val aFourOfAKind = FourOfAKind(Suit.values.map(Card(_, Two)) ++ Seq(Card(Spades, Three))).head

  val aFullHouse = FullHouse(Seq(Hearts, Clubs, Diamonds).map(Card(_, Five)) ++ Seq(Clubs, Diamonds).map(Card(_, Six))).head

  val aFlush = Flush(Seq(Two, Five, Six, Eight, Jack).map(Card(Diamonds, _))).head

  val aStraight = Straight(Seq(Card(Diamonds, Two), Card(Hearts, Three), Card(Hearts, Four), Card(Clubs, Five), Card(Clubs, Six))).head

  val aThreeOfAKind = ThreeOfAKind(Seq(Hearts, Diamonds, Clubs).map(Card(_, Five)) ++
    Seq(Card(Hearts, Seven), Card(Diamonds, Nine))).head

  val aTwoPairs = TwoPairs(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Clubs, Diamonds).map(Card(_, Seven)) ++
    Seq(Card(Hearts, Queen))).head

  val aPair = Pair(Seq(Hearts, Diamonds).map(Card(_, Two)) ++ Seq(Card(Clubs, Seven), Card(Clubs, Eight)) ++
    Seq(Card(Hearts, Queen))).head

  val aHighCard = HighCard(Seq(Card(Hearts, Two), Card(Hearts, Four), Card(Diamonds, Six), Card(Clubs, Ten),
    Card(Clubs, Queen))).head
}
