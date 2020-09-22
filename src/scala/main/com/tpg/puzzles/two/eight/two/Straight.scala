package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.StraightType

class Straight private(override val cards: Seq[Card]) extends PokerHand(StraightType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value > that.handType.value) { return 1 }
    if (this.handType.value < that.handType.value) { return -1 }

    val left = this.cards.map(_.value).sorted.reverse
    val right = that.cards.map(_.value).sorted.reverse

    ranking(left, right, List(0, 1, 2, 3))
  }
}

object Straight extends CorrectSizeCheck with ContainsConsecutiveCards {
  def apply(cards: Seq[Card]): Option[Straight] = {
    if (!correctSize(cards)) { return None }
    if (!containsConsecutiveCards(cards)) { return None }

    Some(new Straight(cards))
  }
}
