package com.tpg.puzzles.two.eight.two

case class Card(suit: Suit, label: String, value: Int) {}

case class PackOfCards(cards: Map[Suit, Seq[Card]]) {}

object PackOfCards {
  def apply(): PackOfCards = {

    val entities = Map("Two" -> 2, "Three" -> 3, "Four" -> 4, "Five" -> 5, "Six" -> 6,
      "Seven" -> 7, "Eight" -> 8, "Nine" -> 9, "Ten" -> 10, "Jack" -> 11, "Queen" -> 12, "King" -> 13)

    val cards = for (suit <- Suit.values; entity <- entities)
      yield Card(suit, entity._1, entity._2)

    PackOfCards(cards.groupBy(_.suit))
  }
}