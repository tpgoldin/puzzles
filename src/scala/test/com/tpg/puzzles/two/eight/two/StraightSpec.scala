package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StraightSpec extends AnyFlatSpec with should.Matchers {
  val straight = Straight(Seq())

  "Straight hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    straight.rank(value) should be > 0
  }
}
