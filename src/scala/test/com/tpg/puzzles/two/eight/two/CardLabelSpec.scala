package com.tpg.puzzles.two.eight.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CardLabelSpec extends AnyFlatSpec with should.Matchers {
  "Card label Two" should "consist of label two, value 2, and symbol '2'" in {
    CardLabel.Two should have (
      'label("Two"),
      'value(2),
      'symbol('2')
    )
  }

  "Card label Three" should "consist of label three, value 3, and symbol '3'" in {
    CardLabel.Three should have (
      'label("Three"),
      'value(3),
      'symbol('3')
    )
  }

  "Card label Four" should "consist of label four, value 4, and symbol '4'" in {
    CardLabel.Four should have (
      'label("Four"),
      'value(4),
      'symbol('4')
    )
  }

  "Card label Five" should "consist of label five, value 5, and symbol '5'" in {
    CardLabel.Five should have (
      'label("Five"),
      'value(5),
      'symbol('5')
    )
  }

  "Card label Six" should "consist of label six, value 6, and symbol '6'"in {
    CardLabel.Six should have (
      'label("Six"),
      'value(6),
      'symbol('6')
    )
  }

  "Card label Seven" should "consist of label seven, value 7, and symbol '7'" in {
    CardLabel.Seven should have (
      'label("Seven"),
      'value(7),
      'symbol('7')
    )
  }

  "Card label Eight" should "consist of label eight, value 8, and symbol '8'" in {
    CardLabel.Eight should have (
      'label("Eight"),
      'value(8),
      'symbol('8')
    )
  }

  "Card label Nine" should "consist of label nine, value 9, and symbol '9'" in {
    CardLabel.Nine should have (
      'label("Nine"),
      'value(9),
      'symbol('9')
    )
  }

  "Card label Ten" should "consist of label ten, value 10, and symbol 'T'" in {
    CardLabel.Ten should have (
      'label("Ten"),
      'value(10),
      'symbol('T')
    )
  }

  "Card label Jack" should "consist of label jack, value 11, and symbol 'J'" in {
    CardLabel.Jack should have (
      'label("Jack"),
      'value(11),
      'symbol('J')
    )
  }

  "Card label Queen" should "consist of label queen, value 12, and symbol 'Q'" in {
    CardLabel.Queen should have (
      'label("Queen"),
      'value(12),
      'symbol('Q')
    )
  }

  "Card label King" should "consist of label king, value 13, and symbol 'K'" in {
    CardLabel.King should have (
      'label("King"),
      'value(13),
      'symbol('K')
    )
  }

  "Card label Ace" should "consist of label ace, value 14, and symbol 'A'" in {
    CardLabel.Ace should have (
      'label("Ace"),
      'value(14),
      'symbol('A')
    )
  }
}
