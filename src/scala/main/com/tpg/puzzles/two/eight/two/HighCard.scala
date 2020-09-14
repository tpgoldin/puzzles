package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.HighCardType

class HighCard(override val cards: Seq[Card]) extends PokerHand(HighCardType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object HighCard {
  def apply(cards: Seq[Card]) : HighCard = new HighCard(cards)
}
