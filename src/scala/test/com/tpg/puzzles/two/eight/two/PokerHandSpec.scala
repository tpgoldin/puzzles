package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts, Spades}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PokerHandSpec extends AnyFlatSpec with should.Matchers {
  val pack = PackOfCards()

  val aStraightFlush = StraightFlush(Seq(Card(Hearts, "Two", 2), Card(Hearts, "Three", 3), Card(Hearts, "Four", 4),
    Card(Hearts, "Five", 5), Card(Hearts, "Six", 6))).head

  val aFourOfAKind = FourOfAKind(Suit.values.map(Card(_, "Two", 2)) ++ Seq(Card(Spades, "Three", 3))).head

  val aFullHouse = FullHouse(Seq(Hearts, Clubs, Diamonds).map(Card(_, "Five", 5)) ++
    Seq(Clubs, Diamonds).map(Card(_, "Six", 6))).head

  val aFlush = Flush(Seq(("Two", 2), ("Five", 5), ("Six", 6), ("Eight", 8), ("Jack", 11)).map(i => Card(Diamonds, i._1, i._2))).head

  val aStraight = Straight(Seq(Card(Diamonds, "Two", 2), Card(Hearts, "Three", 3), Card(Hearts, "Four", 4), Card(Clubs, "Five", 5), Card(Clubs, "Six", 6))).head
}
