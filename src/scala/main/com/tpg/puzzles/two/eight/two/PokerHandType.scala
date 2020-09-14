package com.tpg.puzzles.two.eight.two

sealed case class PokerHandType(value: Int)

object PokerHandType {
  object HighCardType extends PokerHandType(1)
  object PairType extends PokerHandType(2)
  object TwoPairType extends PokerHandType(3)
}
