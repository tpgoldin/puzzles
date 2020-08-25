package com.tpg.puzzles.one.six.two

class ProblemSolver(val n: Int, val m: Int) {
  val grid = Tuple2(n, m)

  def incrementMineCountForSquaresAdjacentTo(r: Int,  c: Int) : Map[Tuple2[Int, Int], Int] = {
    val neighbourhood = new Neighbourhood(grid, r, c)

    val deltaMap = neighbourhood.values.foldLeft(Map[Tuple2[Int, Int], Int]()) { (m, t) => m + (t -> 1) }
    deltaMap
  }
}
