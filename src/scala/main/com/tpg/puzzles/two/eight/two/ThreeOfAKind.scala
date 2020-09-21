package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.ThreeOfAKindType

class ThreeOfAKind private(cards: Seq[Card]) extends PokerHand(ThreeOfAKindType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object ThreeOfAKind extends CorrectSizeCheck {
  def apply(cards: Seq[Card]) : Option[ThreeOfAKind] = {
    if (!correctSize(cards)) { return None }

    val groupBy = cards.groupBy(_.value)
    val aList = groupBy.map(_._2.size).toList

    if (!aList.contains(3)) { return None }

    Some(new ThreeOfAKind(cards))
  }
}