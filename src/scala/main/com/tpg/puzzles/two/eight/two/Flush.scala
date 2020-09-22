package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.FlushType

class Flush private(override val cards: Seq[Card]) extends PokerHand(FlushType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }

    val leftSorted = this.cards.map(_.value).sorted.reverse
    val rightSorted = that.cards.map(_.value).sorted.reverse

    if (leftSorted == rightSorted) { return 0 }

    ranking(leftSorted, rightSorted, (0 to 4).toList)
  }
}

object Flush extends CorrectSizeCheck {
  def apply(cards: Seq[Card]) : Option[Flush] = {
    if (!correctSize(cards)) { return None }

    val groupBy = cards.groupBy(_.suit)
    if (!correctSize(groupBy(cards(0).suit))) { return None }

    Some(new Flush(cards))
  }
}