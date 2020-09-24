package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day.{Friday, Monday, Saturday, Sunday, Thursday, Tuesday, Wednesday}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StrikesSpec extends AnyFlatSpec with should.Matchers {
  "Strikes" should "not contain no strikes days when normalized" in {
    Strikes(HartalParameter(3), Map(3 -> Tuesday, 6 -> Friday, 9 -> Monday, 12 -> Thursday, 15 -> Sunday, 18 -> Wednesday, 21 -> Saturday))
      .strikeDays should contain theSameElementsAs Seq(3 -> Tuesday, 9 -> Monday, 12 -> Thursday, 15 -> Sunday, 18 -> Wednesday)
  }
}
