package com.tpg.puzzles.two.eight.two

case class ProblemSolver(lines: List[String]) {
  def solve() = {
    lines.foreach(l => {
      val players = Players(l)
      val p1 = players._1
      val p2 = players._2

      if (p1.hand.rank(p2.hand) > 0) { println(s"${p1.colour.label} wins.") }
      else if (p1.hand.rank(p2.hand) < 0) { println(s"${p2.colour.label} wins.") }
      else { println("Tie.") }
    })
  }
}

object ProblemSolver {

  def main(args: Array[String]): Unit = {
    val lines = List("2H 3D 5S 9C KD 2C 3H 4S 8C AH", "2H 4S 4C 2D 4H 2S 8S AS QS 3S",
                  "2H 3D 5S 9C KD 2C 3H 4S 8C KH", "2H 3D 5S 9C KD 2D 3H 5C 9S KH")

    val solver = ProblemSolver(lines)
    solver.solve()
  }
}