package com.tpg.puzzles.two.eight.three

case class ProblemSolver(lines: List[String]) {
  val inputLineReader = InputLineReader(lines)

  def solve(): Unit = {
    inputLineReader.testCaseSpecs.foreach(t => {
      val strikeDayMap = DaysMappingGenerator(t.N).generate()

      val parties = t.hps.map(hp => Party(StrikesGenerator(strikeDayMap, HartalParameter(hp), N(t.N))))

      val count = HartalsCounter(strikeDayMap, parties).count
      println(count)
    })
  }
}

object ProblemSolver {
  def main(args: Array[String]): Unit = {

    val solver = ProblemSolver(List("2", "14", "3", "3", "4", "8", "100", "4", "12", "15", "25", "40"))
    solver.solve()
  }
}