package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day.{Friday, Monday, Saturday, Sunday, Thursday, Tuesday, Wednesday}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StrikesSpec extends AnyFlatSpec with should.Matchers {
  "Strikes" should "not contain no strikes days when normalized" in {
    Strikes(HartalParameter(2), Map(2 -> Tuesday, 4 -> Thursday, 6 -> Saturday, 10 -> Monday, 12 -> Wednesday,
      14 -> Friday, 16 -> Sunday))
      .strikeDays should contain theSameElementsAs Seq(2 -> Tuesday, 4 -> Thursday, 10 -> Monday, 12 -> Wednesday,
      16 -> Sunday)
  }
}
