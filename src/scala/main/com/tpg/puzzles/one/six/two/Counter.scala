package com.tpg.puzzles.one.six.two

case class Counter(grid: Grid) {
  def apply(p: Tuple2[Int, Int]): Int = {
    val neighbourhood = new Neighbourhood(grid.size, p._1, p._2)

    neighbourhood.values.count(p => grid(p))
  }
}
