package com.tpg.puzzles.two.eight.four

case class WordToEncodedWordsMapping private(values: Map[String, List[String]]) {
  def apply(key: String) = values(key)
}

object WordToEncodedWordsMapping {
  def apply(values: Map[String, List[String]]) : WordToEncodedWordsMapping = { new WordToEncodedWordsMapping(values) }
}
