package com.tpg.puzzles.one.six.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class ProblemSolverSpec extends AnyFlatSpec with should.Matchers {
  val problemSolver = new ProblemSolver(3, 4)

  "Problem solver" should "set the neighbourhood of the mine square count to 1 for squares adjacent to a mine square in position (0, 0)" in {
    val expectedMap = Map(Tuple2(0, 1) -> 1, Tuple2(1, 0) -> 1, Tuple2(1, 1) -> 1)

    problemSolver.incrementMineCountForSquaresAdjacentTo(0, 0) should contain theSameElementsAs (expectedMap)
  }
}
