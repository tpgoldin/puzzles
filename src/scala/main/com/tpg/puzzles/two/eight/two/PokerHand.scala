package com.tpg.puzzles.two.eight.two

abstract class PokerHand(val handType: PokerHandType, val cards: Seq[Card]) {
}

object PokerHand {
  def apply(cards: Seq[Card]) : Option[PokerHand] = {
    val hand1 = StraightFlush(cards)
    if (hand1.nonEmpty) { return hand1 }

    val hand2 = FourOfAKind(cards)
    if (hand2.nonEmpty) { return hand2 }

    val hand3 = FullHouse(cards)
    if (hand3.nonEmpty) { return hand3 }

    val hand4 = Flush(cards)
    if (hand4.nonEmpty) { return hand4 }

    val hand5 = Straight(cards)
    if (hand5.nonEmpty) { return hand5 }

    val hand6 = ThreeOfAKind(cards)
    if (hand6.nonEmpty) { return hand6 }

    val hand7 = TwoPairs(cards)
    if (hand7.nonEmpty) { return hand7 }

    val hand8 = Pair(cards)
    if (hand8.nonEmpty) { return hand8 }

    HighCard(cards)
  }
}