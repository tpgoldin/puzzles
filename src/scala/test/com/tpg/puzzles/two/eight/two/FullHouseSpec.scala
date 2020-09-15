package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class FullHouseSpec extends AnyFlatSpec with should.Matchers {
  val fullHouse = FullHouse(Seq())

  "Full house hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    fullHouse.rank(value) should be > 0
  }
}
