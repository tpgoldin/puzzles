package com.tpg.puzzles.two.eight.three

import com.tpg.puzzles.two.eight.three.Strikes.StrikeDay

case class Party(strikes: Strikes) {
  def apply(key: StrikeDay) : Option[StrikeDay] = strikes(key)
}
