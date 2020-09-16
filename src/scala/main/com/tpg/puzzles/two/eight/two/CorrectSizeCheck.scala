package com.tpg.puzzles.two.eight.two

trait CorrectSizeCheck {
  def correctSize(cards: Seq[Card]) = cards.size == 5
}
