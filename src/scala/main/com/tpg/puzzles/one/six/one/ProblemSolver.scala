package com.tpg.puzzles.one.six.one

import com.tpg.puzzles.one.six.one.ProblemSolver.DELIMITER

class ProblemSolver {
  def readInput(input: String): Tuple2[Int, Int] = {
    val values = input.split(DELIMITER).map(_.toInt)

    Tuple2(values(0), values(1))
  }

  def generateN(n: Int): Int = {
    (n % 2) match {
      case 0 => n / 2
      case _ => 3 * n + 1
    }
  }

  def generateCycleSequence(currentSequence: Seq[Int], n: Int): Seq[Int] = {
    val newSequence = currentSequence ++ List(n)

    n match {
      case 1 => newSequence
      case _ => generateCycleSequence(newSequence, generateN(n))
    }
  }

  def findMaxCycleLength(i: Int, j: Int): Option[Int] = {
    val range = i to j

    val cycleLengths = range.map(x => generateCycleSequence(Seq(), x).size)

    Some(cycleLengths.max)
  }
}

object ProblemSolver {
  val DELIMITER = " "

  def main(args: Array[String]): Unit = {
    val solver = new ProblemSolver()
    for (ln <- io.Source.stdin.getLines) {
      if (ln.isBlank) { return }

      val ij: Tuple2[Int, Int] = solver.readInput(ln)

      val max = solver.findMaxCycleLength(ij._1, ij._2)

      max.foreach(m => println(s"${ij._1} ${ij._2} $m"))
    }
  }
}