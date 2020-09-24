package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day.{Friday, Monday, Thursday, Tuesday}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StrikesGeneratorSpec extends AnyFlatSpec with should.Matchers {
  "Strikes generator" should "generate a list of strikes" in {
    val hartalParameter = 14

    val daysMapping = DaysMappingGenerator(14).generate()

    val generator = StrikesGenerator(daysMapping, 3, hartalParameter)

    generator.generate() should be(Strikes(hartalParameter, Map((3 -> Tuesday) -> 1, (6 -> Friday) -> 1, (9 -> Monday) -> 1,
      (12, Thursday) -> 1)))
  }
}
