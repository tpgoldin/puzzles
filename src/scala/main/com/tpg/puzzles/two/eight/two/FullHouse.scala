package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.FullHouseType

class FullHouse private(override val cards: Seq[Card]) extends PokerHand(FullHouseType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }
    0
  }
}

object FullHouse extends CorrectSizeCheck {
  def apply(cards: Seq[Card]) : Option[FullHouse] = {
    if (!correctSize(cards)) { return None }

    val groupBy = cards.groupBy(_.value)
    if (groupBy.size != 2) { return None }

    val aList = groupBy.map(_._2.size).toList

    val forAll = Seq(2, 3).forall(i => aList.contains(i))
    if (!forAll) { return None }

    Some(new FullHouse(cards))
  }
}
