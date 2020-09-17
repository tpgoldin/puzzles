package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.TwoPairType

class TwoPairs private(override val cards: Seq[Card]) extends PokerHand(TwoPairType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object TwoPairs extends CorrectSizeCheck {
  def apply(cards: Seq[Card]) : Option[TwoPairs] = {
    if (!correctSize(cards)) { return None }

    val groupBy = cards.groupBy(_.value)
    val groupBySize = groupBy.filter(_._2.size > 1)
    val correctGroupBySize = groupBySize.size == 2

    if (!correctGroupBySize) { return None }

    val sizes = Seq(2, 3)

    val forAll = groupBySize.map(_._2.size).forall(i => sizes.contains(i))

    if (!forAll) { return None }

    Some(new TwoPairs(cards))
  }
}