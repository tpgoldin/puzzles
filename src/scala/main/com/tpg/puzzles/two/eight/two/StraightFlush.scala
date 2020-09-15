package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.StraightFlushType

class StraightFlush(override val cards: Seq[Card]) extends PokerHand(StraightFlushType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    0
  }
}

object StraightFlush {
  def apply(cards: Seq[Card]): StraightFlush = new StraightFlush(cards)
}