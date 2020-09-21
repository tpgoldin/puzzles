package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Colour.{Black, White}

sealed case class Colour(label: String) {
}

object Colour {
  object White extends Colour("White")
  object Black extends Colour("Black")
}

sealed case class Players private(colour: Colour, hand: PokerHand)

object Players {
  def apply(line: String) : Tuple2[Players, Players] = {
    val specs = line.split(" ")

    val blackPokerHand = PokerHand((0 until 5).map(specs(_)).toArray).map(blackPlayer)

    val whitePokerHand = PokerHand((5 until 10).map(specs(_)).toArray).map(whitePlayer)

    val seq = Seq(blackPokerHand, whitePokerHand).flatten

    (seq(0), seq(1))
  }

  def blackPlayer(pokerHand: PokerHand) : Players = Players(Black, pokerHand)


  def whitePlayer(pokerHand: PokerHand) : Players = Players(White, pokerHand)

}
