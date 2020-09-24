package com.tpg.puzzles.two.eight.three

sealed case class Day(label: String, symbol: String) {
  override def toString: String = s"$label"
}

object Day {
  object Sunday extends Day("Sunday", "Su")
  object Monday extends Day("Monday", "Mo")
  object Tuesday extends Day("Tuesday", "Tu")
  object Wednesday extends Day("Wednesday", "We")
  object Thursday extends Day("Thursday", "Th")
  object Friday extends Day("Friday", "Fr")
  object Saturday extends Day("Saturday", "Sa")

  val days = List(Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday)
}
