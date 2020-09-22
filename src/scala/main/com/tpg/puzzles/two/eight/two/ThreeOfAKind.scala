package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.ThreeOfAKindType

class ThreeOfAKind private(cards: Seq[Card]) extends PokerHand(ThreeOfAKindType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }

    val left = this.cards.groupBy(_.value).filter(p => p._2.size > 1).head._1
    val right = that.cards.groupBy(_.value).filter(p => p._2.size > 1).head._1

    left compareTo right
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