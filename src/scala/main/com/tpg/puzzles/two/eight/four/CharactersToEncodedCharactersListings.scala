package com.tpg.puzzles.two.eight.four

import scala.annotation.tailrec

case class CharactersToEncodedCharactersListings private(entry: Tuple2[String, List[String]]) {
  val keyCharacters = entry._1.toList

  private lazy val listings : List[Map[Char, Char]] = {
    val values = entry._2.map(entry._1 -> _)

    buildListings(values, List())
  }

  @tailrec
  private def buildListings(values: List[Tuple2[String, String]], currentListings: List[Map[Char, Char]]) : List[Map[Char, Char]] = {
    val head = values.head
    val tail = values.tail

    val newListings = currentListings ++ List(buildListing(head._1, head._2))

    if (tail.isEmpty) { return newListings }

    buildListings(tail, newListings)
  }

  private def buildListing(key: String, value: String): Map[Char, Char] = key.zip(value).toMap

  def apply(index: Int) : Map[Char, Char] = listings(index)

  def apply(keyChar: Char) : List[Tuple2[Char, Char]] = listings.map(keyChar -> _(keyChar))

  def apply(key: List[Tuple2[Char, Char]]) : Map[Char, Char] = listings.find(m => key.forall(k => m(k._1) == k._2)).getOrElse(Map())

  def apply(keys: List[Char]) : List[Map[Char, Char]] = listings.map(m => Map() ++ keys.map(c => c -> m(c)))
}

object CharactersToEncodedCharactersListings {
  def apply(entry: Tuple2[String, List[String]]) : CharactersToEncodedCharactersListings = new CharactersToEncodedCharactersListings(entry)
}
