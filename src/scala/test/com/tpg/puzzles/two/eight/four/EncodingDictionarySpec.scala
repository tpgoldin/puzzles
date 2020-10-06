package com.tpg.puzzles.two.eight.four

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class EncodingDictionarySpec extends AnyFlatSpec with should.Matchers {
  "EncodingDictionary" should "map key words of a given size to lists of encoded words of the same size" in {
    val keywords = List("and", "jane", "yertle")
    val actual = EncodingDictionary(keywords, "bjvg xsb hxen xsb qymm xsb pnetfn")

    actual("and") should be (List("xsb"))
    actual("jane") should be (List("bjvg", "hxen", "qymm"))
    actual("yertle") should be (List("pnetfn"))
  }
}
