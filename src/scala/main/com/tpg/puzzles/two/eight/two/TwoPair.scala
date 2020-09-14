package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.TwoPairType

class TwoPair(override val cards: Seq[Card]) extends PokerHand(TwoPairType, cards) {
}

object TwoPair {
  def apply(cards: Seq[Card]) = new TwoPair(cards)
}