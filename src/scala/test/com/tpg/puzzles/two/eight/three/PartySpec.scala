package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Day._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PartySpec extends AnyFlatSpec with should.Matchers {
  "Party" should "find a given strike day when it is a strike day for the party" in {
    val strikes = Strikes(HartalParameter(3), Map(3 -> Tuesday, 6 -> Friday, 9 -> Monday, 12 -> Thursday, 15 -> Sunday))

    val party = Party(strikes)

    party(3 -> Tuesday) shouldBe Some(3 -> Tuesday)
  }

  "it" should "not find a given strike day when its not a strike day for the party" in {
    val strikes = Strikes(HartalParameter(3), Map(3 -> Tuesday, 6 -> Friday, 9 -> Monday, 12 -> Thursday, 15 -> Sunday))

    val party = Party(strikes)

    party(4 -> Wednesday) shouldBe None
  }
}
