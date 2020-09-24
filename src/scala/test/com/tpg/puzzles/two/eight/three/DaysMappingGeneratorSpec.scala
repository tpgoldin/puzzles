package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day.{Friday, Monday, Saturday, Sunday, Thursday, Tuesday, Wednesday}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class DaysMappingGeneratorSpec extends AnyFlatSpec with should.Matchers {
  "Days mapping generator" should "generate a day to integer mapping" in {
    val generator = DaysMappingGenerator(14)

    generator.generate() should contain only(1 -> Sunday, 2 -> Monday, 3 -> Tuesday, 4 -> Wednesday, 5 -> Thursday,
      6 -> Friday, 7 -> Saturday, 8 -> Sunday, 9 -> Monday, 10 -> Tuesday, 11 -> Wednesday, 12 -> Thursday, 13 -> Friday,
      14 -> Saturday)
  }
}
