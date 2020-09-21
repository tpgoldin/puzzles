package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Ace, Eight, Five, Four, King, Nine, Three, Two}
import com.tpg.puzzles.two.eight.two.Colour.{Black, White}
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts, Spades}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PlayersSpec extends AnyFlatSpec with should.Matchers {
  val actual = Players("2H 3D 5S 9C KD 2C 3H 4S 8C AH")

  "Black player" should "receive the first five cards from the cards spec" in {
    actual._1.colour should be(Black)
    actual._1.hand.cards should contain theSameElementsAs Seq(Card(Hearts, Two), Card(Diamonds, Three), Card(Spades, Five), Card(Clubs, Nine),
      Card(Diamonds, King))
  }

  "White player" should "receive the last five cards from the cards spec" in {

    actual._2.colour should be(White)
    actual._2.hand.cards should contain theSameElementsAs Seq(Card(Clubs, Two), Card(Hearts, Three), Card(Spades, Four),
      Card(Clubs, Eight), Card(Hearts, Ace))
  }
}
