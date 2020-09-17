package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.HighCardType

class HighCard private(override val cards: Seq[Card]) extends PokerHand(HighCardType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object HighCard extends CorrectSizeCheck {
  def apply(cards: Seq[Card]) : Option[HighCard] = {
    if (!correctSize(cards)) { return None }

    Some(new HighCard(cards))
  }
}
