package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day.{Friday, Monday, Thursday, Tuesday}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StrikesGeneratorSpec extends AnyFlatSpec with should.Matchers {
  "Strikes generator" should "generate a list of strikes" in {
    val hartalParameter = HartalParameter(3)

    val daysMapping = DaysMappingGenerator(14).generate()

    val generator = StrikesGenerator(daysMapping, hartalParameter, N(14))

    generator.generate() should be(Strikes(hartalParameter, Map(3 -> Tuesday, 6 -> Friday, 9 -> Monday, 12 -> Thursday)))
  }
}
