package com.tpg.puzzles.one.six.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import scala.collection.immutable.TreeMap

class ProblemSolverSpec extends AnyFlatSpec with should.Matchers {
  val problemSolver = new ProblemSolver(Seq("*..*", ".*..", "*..."))

  "Problem solver" should "generate a count of asterisks in the neighbourhood of all points in the grid" in {

    val expected = TreeMap(
      (0, 0) -> new AsteriskOrCount, (0, 1) -> new AsteriskOrCount(2), (0, 2) -> new AsteriskOrCount(2),
      (0, 3) -> new AsteriskOrCount,
      (1, 0) -> new AsteriskOrCount(3), (1, 1) -> new AsteriskOrCount, (1, 2) -> new AsteriskOrCount(2),
      (1, 3) -> new AsteriskOrCount(1),
      (2, 0) -> new AsteriskOrCount, (2, 1) -> new AsteriskOrCount(2), (2, 2) -> new AsteriskOrCount(1),
      (2, 3) -> new AsteriskOrCount(0)
    )

    problemSolver.solve should (contain theSameElementsAs expected)
  }
}
