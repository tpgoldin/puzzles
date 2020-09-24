package com.tpg.puzzles.two.eight.three

import scala.annotation.tailrec

case class DaysMappingGenerator(n: Int) {
  private val days = Day.days

  def generate() : Map[Int, Day] = {
    buildDaysMapping((1 to n).toList, 0, Map())
  }

  @tailrec
  private def buildDaysMapping(range: List[Int], index: Int, currentMap: Map[Int, Day]) : Map[Int, Day] = {
    val head = range.head
    val tail = range.tail

    val newMap = currentMap + (head -> days(index % 7))

    if (tail.isEmpty) { return newMap }

    buildDaysMapping(tail, index + 1, newMap)
  }
}
