package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.PokerHandType.HighCardType

class HighCard private(override val cards: Seq[Card]) extends PokerHand(HighCardType, cards) with Rank {
  override def rank(that: PokerHand): Int = {
    if (this.handType.value < that.handType.value) { return -1 }

    if (this.cards.map(_.value).max > that.cards.map(_.value).max) { return 1 }

    val left = this.cards.map(_.value).sorted.reverse
    val right = that.cards.map(_.value).sorted.reverse

    val range = (0 until 5).toList
    ranking(left, right, range)
  }

  private def ranking(left: Seq[Int], right: Seq[Int], range: List[Int]) : Int = {
    val head = range.head
    val tail = range.tail

    if (tail.isEmpty) { return 0 }
    if (left(head) > right(head)) { return 1 }

    if (left(head) == right(head)) { return ranking(left, right, tail) }

    -1
  }
}

object HighCard extends CorrectSizeCheck {
  def apply(cards: Seq[Card]) : Option[HighCard] = {
    if (!correctSize(cards)) { return None }

    Some(new HighCard(cards))
  }
}
