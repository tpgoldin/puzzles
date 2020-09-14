package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.PairType

class Pair(cards: Seq[Card]) extends PokerHand(PairType, cards) {}

object Pair {
  def apply(cards: Seq[Card]): Pair = new Pair(cards)
}
