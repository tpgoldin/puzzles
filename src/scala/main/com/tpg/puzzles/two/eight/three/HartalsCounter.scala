package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Strikes.StrikeDayMap

case class HartalsCounter(daysMapping: StrikeDayMap, parties: Seq[Party]) {
  def count() : Int = {
    val strikeDays = daysMapping.map(key => key -> parties.exists(p => p(key).nonEmpty))
    strikeDays.count(_._2 == true)
  }
}
