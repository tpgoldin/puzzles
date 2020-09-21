package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.Color.{Black, White}

sealed case class Color(label: String) {
}

object Color {
  object White extends Color("White")
  object Black extends Color("Black")
}

sealed case class Player(color: Color, pokerHand: PokerHand)

object Player {
  def blackPlayer(cards: Seq[Card]) : Option[Player] = {
    val pokerHand = PokerHand(cards)
    pokerHand.map(Player(Black, _))
  }
}
