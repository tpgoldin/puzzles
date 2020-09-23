package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.FourOfAKindType

class FourOfAKind private(override val cards: Seq[Card]) extends PokerHand(FourOfAKindType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }

    val left = this.groupByValue().filter(_._2.size == 4).head._1
    val right = that.groupByValue().filter(_._2.size == 4).head._1

    left compareTo right
  }
}

object FourOfAKind extends CorrectSizeCheck {
  def apply(cards: Seq[Card]) : Option[FourOfAKind] = {
    if (!correctSize(cards)) { return None }

    val groupBy = cards.groupBy(_.value)
    val aList = groupBy.map(_._2.size).toList

    val forAll = Seq(1, 4).forall(aList.contains(_))
    if (!forAll) { return None }

    Some(new FourOfAKind(cards))
  }
}