package com.tpg.puzzles.two.eight.two

sealed case class Suit (value: String) {}

object Suit {
  object Hearts extends Suit("H")
  object Diamonds extends Suit("D")
  object Clubs extends Suit("C")
  object Spades extends Suit("S")

  val values = Seq(Hearts, Diamonds, Clubs, Spades)
}
