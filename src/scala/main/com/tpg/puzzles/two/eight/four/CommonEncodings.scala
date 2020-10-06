package com.tpg.puzzles.two.eight.four

case class CommonEncodings(listings1: CharactersToEncodedCharactersListings, listings2: CharactersToEncodedCharactersListings) {
  def merged(): Map[Char, Char] = {
    val commonChars = listings1.keyCharacters.intersect(listings2.keyCharacters)

    val intersection = listings1(commonChars).intersect(listings2(commonChars)).flatten

    val v1: Map[Char, Char] = listings1(intersection)
    val v2: Map[Char, Char] = listings2(intersection)

    v1 ++ v2
  }
}
