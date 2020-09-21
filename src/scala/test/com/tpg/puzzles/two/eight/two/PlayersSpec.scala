package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Ace, Eight, Five, Four, King, Nine, Three, Two}
import com.tpg.puzzles.two.eight.two.Colour.{Black, White}
import com.tpg.puzzles.two.eight.two.Suit.{Clubs, Diamonds, Hearts, Spades}
import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.matchers.should

class PlayersSpec extends AnyFeatureSpec with GivenWhenThen with should.Matchers {

  feature("Black player") {
    scenario("generated from the first five cards of the cards spec") {
      Given("a cards spec")
      val line = "2H 3D 5S 9C KD 2C 3H 4S 8C AH"

      When("generating the players")
      val actual = Players(line)

      Then("a black player is generated with a poker hand defined with the first five card specs")
      actual._1.colour should be(Black)
      actual._1.hand.cards should contain theSameElementsAs Seq(Card(Hearts, Two), Card(Diamonds, Three), Card(Spades, Five), Card(Clubs, Nine),
        Card(Diamonds, King))
    }
  }

  feature("White player") {
    scenario("generated from the last five cards of the cards spec") {
      Given("a cards spec")
      val line = "2H 3D 5S 9C KD 2C 3H 4S 8C AH"

      When("generating the players")
      val actual = Players(line)

      Then("a white player is generated with a poker hand defined from the last five card specs")
      actual._2.colour should be(White)
      actual._2.hand.cards should contain theSameElementsAs Seq(Card(Clubs, Two), Card(Hearts, Three), Card(Spades, Four),
        Card(Clubs, Eight), Card(Hearts, Ace))
    }
  }
}
