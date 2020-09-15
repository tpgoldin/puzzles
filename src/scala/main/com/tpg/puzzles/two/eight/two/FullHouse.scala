package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.FullHouseType

class FullHouse(override val cards: Seq[Card]) extends PokerHand(FullHouseType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    0
  }
}

object FullHouse {
  def apply(cards: Seq[Card]) = new FullHouse(cards)
}
