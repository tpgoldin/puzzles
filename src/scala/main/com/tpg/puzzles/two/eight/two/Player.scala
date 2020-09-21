package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Colour.{Black, White}

sealed case class Colour(label: String) {
}

object Colour {
  object White extends Colour("White")
  object Black extends Colour("Black")
}

sealed case class Player private(colour: Colour, hand: PokerHand)

object Player {
  def apply(line: String) : Tuple2[Player, Player] = {
    val specs = line.split(" ")

    val blackPokerHand = PokerHand((0 until 5).map(specs(_)).toArray).map(blackPlayer)

    val whitePokerHand = PokerHand((5 until 10).map(specs(_)).toArray).map(whitePlayer)

    val seq = Seq(blackPokerHand, whitePokerHand).flatten

    (seq(0), seq(1))
  }

  def blackPlayer(pokerHand: PokerHand) : Player = Player(Black, pokerHand)


  def whitePlayer(pokerHand: PokerHand) : Player = Player(White, pokerHand)

}
