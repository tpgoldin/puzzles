package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CardLabelSpec extends AnyFlatSpec with should.Matchers {
  "Card label Two" should "consist of label two and value 2" in {
    CardLabel.Two should have (
      'label("Two"),
      'value(2)
    )
  }

  "Card label Three" should "consist of label three and value 3" in {
    CardLabel.Three should have (
      'label("Three"),
      'value(3)
    )
  }

  "Card label Four" should "consist of label four and value 4" in {
    CardLabel.Four should have (
      'label("Four"),
      'value(4)
    )
  }

  "Card label Five" should "consist of label five and value 5" in {
    CardLabel.Five should have (
      'label("Five"),
      'value(5)
    )
  }

  "Card label Six" should "consist of label six and value 6"in {
    CardLabel.Six should have (
      'label("Six"),
      'value(6)
    )
  }

  "Card label Seven" should "consist of label seven and value 7" in {
    CardLabel.Seven should have (
      'label("Seven"),
      'value(7)
    )
  }

  "Card label Eight" should "consist of label eight and value 8" in {
    CardLabel.Eight should have (
      'label("Eight"),
      'value(8)
    )
  }

  "Card label Nine" should "consist of label nine and value 9" in {
    CardLabel.Nine should have (
      'label("Nine"),
      'value(9)
    )
  }

  "Card label Ten" should "consist of label ten and value 10" in {
    CardLabel.Ten should have (
      'label("Ten"),
      'value(10)
    )
  }

  "Card label Jack" should "consist of label jack and value 11" in {
    CardLabel.Jack should have (
      'label("Jack"),
      'value(11)
    )
  }

  "Card label Queen" should "consist of label queen and value 12" in {
    CardLabel.Queen should have (
      'label("Queen"),
      'value(12)
    )
  }

  "Card label King" should "consist of label king and value 13"in {
    CardLabel.King should have (
      'label("King"),
      'value(13)
    )
  }

  "Card label Ace" should "consist of label ace and value 14"in {
    CardLabel.Ace should have (
      'label("Ace"),
      'value(14)
    )
  }
}
