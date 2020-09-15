package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class FlushSpec extends AnyFlatSpec with should.Matchers {
  val flush = Flush(Seq())

  "Flush hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    flush.rank(value) should be > 0
  }
}
