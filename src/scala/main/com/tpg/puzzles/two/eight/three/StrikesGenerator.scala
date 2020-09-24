package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day.{Friday, Saturday}
import com.tpg.puzzles.two.eight.three.Strikes.{NoStrikeDays, StrikeDayMap}

import scala.annotation.tailrec

case class N(value: Int)

case class HartalParameter(value: Int) {
  def range(n: N) = ((value to n.value) by value) toList
}

case class Strikes(hartalParameter: HartalParameter, strikeDays: StrikeDayMap) {
  def normalize() : StrikeDayMap = {
    filterStrikeDays(NoStrikeDays, strikeDays)
  }

  @tailrec
  private def filterStrikeDays(noStrikeDays: Seq[Day], strikeDays: StrikeDayMap): StrikeDayMap = {
    val head = noStrikeDays.head
    val tail = noStrikeDays.tail

    val reducedMap = strikeDays.filterNot(_._2 == head)

    if (tail.isEmpty) { return reducedMap }

    filterStrikeDays(tail, reducedMap)
  }
}

object Strikes {
  type StrikeDayMap = Map[Int, Day]

  val NoStrikeDays = Seq(Friday, Saturday)
}

case class StrikesGenerator(daysMapping: Map[Int, Day], hartalParameter: HartalParameter, n: N) {
  def generate(): Strikes = Strikes(hartalParameter, buildStrikeDays(hartalParameter.range(n)))

  private def buildStrikeDays(range: List[Int]): StrikeDayMap = range.flatMap(i => daysMapping.find(_._1 == i)).toMap
}
