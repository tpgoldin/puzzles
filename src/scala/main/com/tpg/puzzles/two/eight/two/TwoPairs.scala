package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.TwoPairType

class TwoPairs private(override val cards: Seq[Card]) extends PokerHand(TwoPairType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object TwoPairs {
  def apply(cards: Seq[Card]) : Option[TwoPairs] = Some(new TwoPairs(cards))
}