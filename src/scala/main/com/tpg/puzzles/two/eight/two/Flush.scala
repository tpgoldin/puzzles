package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.FlushType

class Flush(override val cards: Seq[Card]) extends PokerHand(FlushType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object Flush {
  def apply(cards: Seq[Card]) : Flush = new Flush(cards)
}