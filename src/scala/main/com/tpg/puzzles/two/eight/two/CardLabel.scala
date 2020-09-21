package com.tpg.puzzles.two.eight.two

sealed case class CardLabel(label: String, value: Int, symbol: Char) {}

object CardLabel {
  object Two extends CardLabel("Two", 2, '2')
  object Three extends CardLabel("Three", 3, '3')
  object Four extends CardLabel("Four", 4, '4')
  object Five extends CardLabel("Five", 5, '5')
  object Six extends CardLabel("Six", 6, '6')
  object Seven extends CardLabel("Seven", 7, '7')
  object Eight extends CardLabel("Eight", 8, '8')
  object Nine extends CardLabel("Nine",9, '9')
  object Ten extends CardLabel("Ten",10, 'T')
  object Jack extends CardLabel("Jack",11, 'J')
  object Queen extends CardLabel("Queen",12, 'Q')
  object King extends CardLabel("King",13, 'K')
  object Ace extends CardLabel("Ace",14, 'A')

  val values = Seq(Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace)

  def apply(symbol: Char) : Option[CardLabel] = values.find(_.symbol == symbol)
}
