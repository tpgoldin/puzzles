package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class HartalsCounterSpec extends AnyFlatSpec with should.Matchers {
  "HartalsCounter" should "count the number of hartals for a given collection of parties" in {
    val party1 = Party(Strikes(HartalParameter(3), Map(3 -> Tuesday, 6 -> Friday, 9 -> Monday, 12 -> Thursday)))
    val party2 = Party(Strikes(HartalParameter(4), Map(4 -> Wednesday, 8 -> Sunday, 12 -> Thursday)))
    val party3 = Party(Strikes(HartalParameter(8), Map(8 -> Sunday)))

    val counter = HartalsCounter(DaysMappingGenerator(14).generate(), Seq(party1, party2, party3))
    counter.count should be(5)
  }
}
