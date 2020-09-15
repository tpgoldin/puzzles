package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.FourOfAKindType

class FourOfAKind(cards: Seq[Card]) extends PokerHand(FourOfAKindType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    0
  }
}

object FourOfAKind {
  def apply(cards: Seq[Card]) : FourOfAKind = new FourOfAKind(cards)
}