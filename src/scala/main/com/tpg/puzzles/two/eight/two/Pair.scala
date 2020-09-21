package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.PairType

class Pair private(override val cards: Seq[Card]) extends PokerHand(PairType, cards) {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }

    val leftGroupBy = this.cards.groupBy(_.value)
    val leftFound = leftGroupBy.find(p => p._2.size == 2).get
    val rightGroupBy = that.cards.groupBy(_.value)
    val rightFound = rightGroupBy.find(p => p._2.size == 2).get

    if (leftFound._1 > rightFound._1) { return 1 }
    if (leftFound._1 < rightFound._1) { return -1 }

    val leftSorted = this.cards.filter(p => p.value != leftFound._1).map(_.value).sorted
    val rightSorted = that.cards.filter(p => p.value != leftFound._1).map(_.value).sorted

    val range = (0 until 3).toList
    ranking(leftSorted, rightSorted, range)
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
