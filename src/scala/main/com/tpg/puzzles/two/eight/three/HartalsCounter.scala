package com.tpg.puzzles.two.eight.three

case class HartalsCounter(daysMappingGenerator: DaysMappingGenerator, parties: Seq[Party]) {
  def count() : Int = {
    val daysMapping = daysMappingGenerator.generate()
    val strikeDays = daysMapping.map(key => key -> parties.exists(p => p(key).nonEmpty))
    strikeDays.count(_._2 == true)
  }
}
