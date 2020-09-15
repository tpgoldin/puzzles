package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.ThreeOfAKindType

class FourOfAKind(cards: Seq[Card]) extends PokerHand(ThreeOfAKindType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    0
  }
}

object FourOfAKind {
  def apply(cards: Seq[Card]) = new FourOfAKind(cards)
}