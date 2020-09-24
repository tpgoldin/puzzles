package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day.{Friday, Saturday}
import com.tpg.puzzles.two.eight.three.Strikes.NoStrikeDays

case class Strikes(hartalParameter: Int, strikeDays: Map[(Int, Day), Int]) {
  def normalize() : Map[(Int, Day), Int] = {
    filterStrikeDays(NoStrikeDays, strikeDays)
  }

  private def filterStrikeDays(noStrikeDays: Seq[Day], strikeDays: Map[(Int, Day), Int]): Map[(Int, Day), Int] = {
    val head = noStrikeDays.head
    val tail = noStrikeDays.tail

    val reducedMap = strikeDays.filterNot(_._1._2 == head)

    if (tail.isEmpty) { return reducedMap }

    filterStrikeDays(tail, reducedMap)
  }
}

object Strikes {
  val NoStrikeDays = Seq(Friday, Saturday)
}

case class StrikesGenerator(daysMapping: Map[Int, Day], hartalParameter: Int, n: Int) {
  def generate(): Strikes = {
    val range = ((hartalParameter to n) by hartalParameter).toList

    Strikes(hartalParameter, buildStrikeDays(range))
  }

  private def buildStrikeDays(range: List[Int]): Map[(Int, Day), Int] =
    range.flatMap(i => daysMapping.find(_._1 == i).map(entry => entry -> 1)).toMap
}
