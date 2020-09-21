package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.PairType

class Pair private(override val cards: Seq[Card]) extends PokerHand(PairType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object Pair extends CorrectSizeCheck {
  def apply(cards: Seq[Card]) : Option[Pair] = {
    if (!correctSize(cards)) { return None }

    val groupBy = cards.groupBy(_.value)

    if (groupBy.count(_._2.size == 2)!= 1) { return None }

    Some(new Pair(cards))
  }
}
