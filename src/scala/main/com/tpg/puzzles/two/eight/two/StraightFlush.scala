package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.StraightFlushType

class StraightFlush private(override val cards: Seq[Card]) extends PokerHand(StraightFlushType, cards.sortBy(_.value)) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    0
  }
}

object StraightFlush extends CorrectSizeCheck with ContainsConsecutiveCards {
  def apply(cards: Seq[Card]): Option[StraightFlush] = {

    if (!correctSize(cards)) { return None }
    if (!sameSuit(cards)) { return None }
    if (!containsConsecutiveCards(cards)) { return None }

    Some(new StraightFlush(cards))
  }

  private def sameSuit(cards: Seq[Card]): Boolean = cards.groupBy(_.suit).size == 1
}