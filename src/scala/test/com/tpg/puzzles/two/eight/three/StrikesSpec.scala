package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day.{Friday, Monday, Thursday, Tuesday}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StrikesSpec extends AnyFlatSpec with should.Matchers {
  "Strikes" should "not contain strikes days when normalized" in {
    Strikes(14, Map((3 -> Tuesday) -> 1, (6 -> Friday) -> 1, (9 -> Monday) -> 1, (12, Thursday) -> 1))
      .normalize() should contain theSameElementsAs Seq((3 -> Tuesday) -> 1, (9 -> Monday) -> 1, (12, Thursday) -> 1)
  }
}
