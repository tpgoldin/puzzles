package com.tpg.puzzles.two.eight.two

trait ContainsConsecutiveCards {
  def containsConsecutiveCards(cards: Seq[Card]) : Boolean = {
    val values = cards.map(_.value)

    val min = values.min
    val max = values.max

    val range = min to max

    range.forall(i => cards.exists(_.value == i))
  }
}
