package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class StraightFlushSpec extends AnyFlatSpec with should.Matchers {
  val straightFlush = StraightFlush(Seq())

  "Flush hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    straightFlush.rank(value) should be > 0
  }
}
