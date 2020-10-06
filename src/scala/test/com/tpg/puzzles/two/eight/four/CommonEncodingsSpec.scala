package com.tpg.puzzles.two.eight.four

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CommonEncodingsSpec extends AnyFlatSpec with should.Matchers {
  "Common encodings" should "merge the common word encodings" in {
    val listings1 = CharactersToEncodedCharactersListings("and" -> List("xsb", "yjm"))
    val listings2 = CharactersToEncodedCharactersListings("stain" -> List("zdxhs", "ertyu"))

    val actual = CommonEncodings(listings1, listings2)

    val expected = Map('a'-> 'x', 'n' -> 's', 'd' -> 'b') ++
      Map('s' -> 'z', 't' -> 'd', 'a' -> 'x', 'i' -> 'h', 'n' -> 's')

    actual.merged() should be (expected)
  }
}
