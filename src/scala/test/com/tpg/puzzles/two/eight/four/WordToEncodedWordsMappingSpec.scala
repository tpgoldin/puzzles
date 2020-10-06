package com.tpg.puzzles.two.eight.four

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class WordToEncodedWordsMappingSpec extends AnyFlatSpec with should.Matchers {
  "WordToEncodedWordsMapping" should "map a word to a list of encoded words" in {
    val actual = WordToEncodedWordsMapping(Map("and"-> List("xsb", "yjm")))

    actual("and") should be(List("xsb", "yjm"))
  }
}
