package com.tpg.puzzles.two.eight.two

import com.tpg.puzzles.two.eight.two.CardLabel.{Ace, Eight, Five, Four, Jack, King, Nine, Queen, Seven, Six, Ten, Three, Two}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CardLabelSpec extends AnyFlatSpec with should.Matchers {
  "Card label Two" should "consist of label two, value 2, and symbol '2'" in {
    Two should have (
      'label("Two"),
      'value(2),
      'symbol('2')
    )

    CardLabel('2') shouldBe Some(Two)
  }

  "Card label Three" should "consist of label three, value 3, and symbol '3'" in {
    Three should have (
      'label("Three"),
      'value(3),
      'symbol('3')
    )

    CardLabel('3') shouldBe Some(Three)
  }

  "Card label Four" should "consist of label four, value 4, and symbol '4'" in {
    Four should have (
      'label("Four"),
      'value(4),
      'symbol('4')
    )

    CardLabel('4') shouldBe Some(Four)
  }

  "Card label Five" should "consist of label five, value 5, and symbol '5'" in {
    Five should have (
      'label("Five"),
      'value(5),
      'symbol('5')
    )

    CardLabel('5') shouldBe Some(Five)
  }

  "Card label Six" should "consist of label six, value 6, and symbol '6'"in {
    Six should have (
      'label("Six"),
      'value(6),
      'symbol('6')
    )

    CardLabel('6') shouldBe Some(Six)
  }

  "Card label Seven" should "consist of label seven, value 7, and symbol '7'" in {
    Seven should have (
      'label("Seven"),
      'value(7),
      'symbol('7')
    )

    CardLabel('7') shouldBe Some(Seven)
  }

  "Card label Eight" should "consist of label eight, value 8, and symbol '8'" in {
    Eight should have (
      'label("Eight"),
      'value(8),
      'symbol('8')
    )

    CardLabel('8') shouldBe Some(Eight)
  }

  "Card label Nine" should "consist of label nine, value 9, and symbol '9'" in {
    Nine should have (
      'label("Nine"),
      'value(9),
      'symbol('9')
    )

    CardLabel('9') shouldBe Some(Nine)
  }

  "Card label Ten" should "consist of label ten, value 10, and symbol 'T'" in {
    Ten should have (
      'label("Ten"),
      'value(10),
      'symbol('T')
    )

    CardLabel('T') shouldBe Some(Ten)
  }

  "Card label Jack" should "consist of label jack, value 11, and symbol 'J'" in {
    Jack should have (
      'label("Jack"),
      'value(11),
      'symbol('J')
    )

    CardLabel('J') shouldBe Some(Jack)
  }

  "Card label Queen" should "consist of label queen, value 12, and symbol 'Q'" in {
    Queen should have (
      'label("Queen"),
      'value(12),
      'symbol('Q')
    )

    CardLabel('Q') shouldBe Some(Queen)
  }

  "Card label King" should "consist of label king, value 13, and symbol 'K'" in {
    King should have (
      'label("King"),
      'value(13),
      'symbol('K')
    )

    CardLabel('K') shouldBe Some(King)
  }

  "Card label Ace" should "consist of label ace, value 14, and symbol 'A'" in {
    Ace should have (
      'label("Ace"),
      'value(14),
      'symbol('A')
    )

    CardLabel('A') shouldBe Some(Ace)
  }
}
