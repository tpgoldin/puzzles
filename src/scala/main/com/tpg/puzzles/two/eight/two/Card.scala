package com.tpg.puzzles.two.eight.two

case class Card(suit: Suit, private val cardLabel: CardLabel) {
  val label = cardLabel.label
  val value = cardLabel.value

  override def toString: String = s"$label of $suit"
}

case class PackOfCards private(cards: Map[Suit, Seq[Card]]) {}

object PackOfCards {
  def apply(): PackOfCards = {

    val labels = CardLabel.values

    val cards = for (suit <- Suit.values; label <- labels)
      yield Card(suit, label)

    PackOfCards(cards.groupBy(_.suit))
  }
}