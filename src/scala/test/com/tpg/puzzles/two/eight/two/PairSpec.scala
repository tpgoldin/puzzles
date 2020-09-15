package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PairSpec extends AnyFlatSpec with should.Matchers {
  val pair = Pair(Seq())

  "Pair hand" should "rank higher than a high card hand" in {
    val value = HighCard(Seq())

    pair.rank(value) should be > 0
  }
}
