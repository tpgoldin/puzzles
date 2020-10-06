package com.tpg.puzzles.two.eight.four

case class EncodingDictionary(keywords: List[String], encryptedLine: String) {
  private val mapping: Map[String, List[String]] = buildMapping()

  private def buildMapping() : Map[String, List[String]] = {
    val groupBy = encryptedLine.split(" ").distinct.toList.groupBy(_.length).toList

    buildMapping(groupBy, Map())
  }

  private def buildMapping(groupBy: List[(Int, List[String])], currentMap: Map[String, List[String]]) : Map[String, List[String]] = {
    val head = groupBy.head
    val tail = groupBy.tail

    val keywordGroupBy = keywords.groupBy(_.length)

    val newMap = currentMap ++ keywordGroupBy(head._1).map(_ -> head._2).toMap

    if (tail.isEmpty) { return newMap }
    buildMapping(tail, newMap)
  }

  def apply(key: String) : List[String] = mapping(key)
}
