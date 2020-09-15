package com.tpg.puzzles.two.eight.two

sealed case class PokerHandType(value: Int)

object PokerHandType {
  object HighCardType extends PokerHandType(2)
  object PairType extends PokerHandType(3)
  object TwoPairType extends PokerHandType(5)
  object ThreeOfAKindType extends PokerHandType(7)
  object StraightType extends PokerHandType(11)
}
