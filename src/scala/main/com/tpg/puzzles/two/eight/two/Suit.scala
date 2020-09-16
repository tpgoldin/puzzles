package com.tpg.puzzles.two.eight.two

sealed case class Suit (label: String, value: String) {
  override def toString: String = label
}

object Suit {
  object Hearts extends Suit("Hearts", "H")
  object Diamonds extends Suit("Diamonds", "D")
  object Clubs extends Suit("Clubs", "C")
  object Spades extends Suit("Spades", "S")

  val values = Seq(Hearts, Diamonds, Clubs, Spades)
}
