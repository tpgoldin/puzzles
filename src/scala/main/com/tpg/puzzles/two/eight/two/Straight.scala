package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.StraightType

class Straight(override val cards: Seq[Card]) extends PokerHand(StraightType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object Straight {
  def apply(cards: Seq[Card]): Straight = new Straight(cards)
}
