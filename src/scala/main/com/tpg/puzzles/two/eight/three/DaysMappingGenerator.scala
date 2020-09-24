package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Strikes.StrikeDayMap

import scala.annotation.tailrec

case class DaysMappingGenerator private(n: N) {
  private val days = Day.days

  def generate() : StrikeDayMap = {
    buildDaysMapping((1 to n.value).toList, 0, Map())
  }

  @tailrec
  private def buildDaysMapping(range: List[Int], index: Int, currentMap: StrikeDayMap) : StrikeDayMap = {
    val head = range.head
    val tail = range.tail

    val newMap = currentMap + (head -> days(index % 7))

    if (tail.isEmpty) { return newMap }

    buildDaysMapping(tail, index + 1, newMap)
  }
}

object DaysMappingGenerator {
  def apply(n: Int) : DaysMappingGenerator = new DaysMappingGenerator(N(n))
}
