package com.tpg.puzzles.two.eight.two

sealed case class CardLabel(label: String, value: Int) {
  val symbol: String = value.toString
}

object CardLabel {
  object Two extends CardLabel("Two", 2)
  object Three extends CardLabel("Three", 3)
  object Four extends CardLabel("Four", 4)
  object Five extends CardLabel("Five", 5)
  object Six extends CardLabel("Six", 6)
  object Seven extends CardLabel("Seven", 7)
  object Eight extends CardLabel("Eight", 8)
  object Nine extends CardLabel("Nine",9)
  object Ten extends CardLabel("Ten",10)
  object Jack extends CardLabel("Jack",11)
  object Queen extends CardLabel("Queen",12)
  object King extends CardLabel("King",13)
  object Ace extends CardLabel("Ace",14)

  val values = Seq(Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten)

  def apply(symbol: String) : Option[CardLabel] = values.find(_.symbol == symbol)
}
