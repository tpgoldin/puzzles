package com.tpg.puzzles.two.eight.four

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CharactersToEncodedCharactersListingsSpec extends AnyFlatSpec with should.Matchers {
  val actual = CharactersToEncodedCharactersListings("and" -> List("xsb", "yjm"))

  "CharactersToEncodedCharactersListings" should "list the characters to encoded characters" in {
    actual(0) should be(Map('a'-> 'x', 'n' -> 's', 'd' -> 'b'))
    actual(1) should be(Map('a'-> 'y', 'n' -> 'j', 'd' -> 'm'))
  }

  "it" should "select a given encoding for a given keyword character to encoded character mapping" in {
    actual(List('a' -> 'y', 'd' -> 'm')) should be(Map('a'-> 'y', 'n' -> 'j', 'd' -> 'm'))
  }

  "it" should ""
}
