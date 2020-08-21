package com.tpg.puzzles.one.six.one

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class ProblemSolverSpec extends AnyFlatSpec with should.Matchers {
  val problemSolver = new ProblemSolver()

  "Problem solver" should "generate n / 2 when n is even" in {
    problemSolver.generateN(4) should be (2)
  }

  it should "read the integer pair from input string" in {
    problemSolver.readInput("2 5") should be (Tuple2(2, 5))
  }

  it should "generate 3n + 1 when n is odd" in {
    problemSolver.generateN(5) should be (16)
  }

  it should "generate a cycle sequence of length one when n = 1" in {
    problemSolver.generateCycleSequence(Seq(), 1) should contain theSameElementsAs Seq(1)
  }

  it should "generate a cycle sequence of length greater than 1 when n is greater than 1" in {
    problemSolver.generateCycleSequence(Seq(), 5) should contain theSameElementsAs Seq(5, 16, 8, 4, 2, 1)
  }

  it should "find the maximum cycle length for n = i to j inclusive" in {
    problemSolver.findMaxCycleLength(4, 5) should be (Some(6))
  }

  it should "find the maximum cycle length for n = i to j inclusive when i equals j" in {
    problemSolver.findMaxCycleLength(4, 4) should be (Some(3))
  }
}
