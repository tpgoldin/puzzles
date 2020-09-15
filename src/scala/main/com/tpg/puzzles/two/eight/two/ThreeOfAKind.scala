package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.ThreeOfAKindType

class ThreeOfAKind(cards: Seq[Card]) extends PokerHand(ThreeOfAKindType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object ThreeOfAKind {
  def apply(cards: Seq[Card]) : ThreeOfAKind = new ThreeOfAKind(cards)
}