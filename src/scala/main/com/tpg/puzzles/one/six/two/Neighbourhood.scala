package com.tpg.puzzles.one.six.two

case class Neighbourhood(grid: Tuple2[Int, Int], r: Int, c: Int) {
  private val m = grid._1
  private val n = grid._2

  val values = createNeighbourhood()

  private def createNeighbourhood() : Seq[Tuple2[Int, Int]] = {
    val rows = (r-1 to r+1).filterNot( x => x < 0 || x >= m)
    val cols = (c-1 to c+1).filterNot( y => y < 0 || y >= n)

    val temp = for {
      i <- rows
      j <- cols
    } yield {
      (i, j)
    }

    temp.filterNot(p => p._1 == r && p._2 == c)
  }
}
