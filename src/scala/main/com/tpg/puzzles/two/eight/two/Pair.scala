package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.PairType

class Pair(override val cards: Seq[Card]) extends PokerHand(PairType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object Pair {
  def apply(cards: Seq[Card]): Pair = new Pair(cards)
}
