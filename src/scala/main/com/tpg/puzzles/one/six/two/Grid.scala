package com.tpg.puzzles.one.six.two

case class Grid(lines: Seq[String]) {
  val size = (lines.size, lines(0).size)

  val value = readLines()

  def apply(p : Tuple2[Int, Int]): Boolean = {
    value.contains(p)
  }

  private def readLines(): Seq[Tuple2[Int, Int]] = {
    readLine(Seq(), 0, lines)
  }

  private def readLine(currentSeq: Seq[Tuple2[Int, Int]], row: Int, currentLines: Seq[String]) : Seq[Tuple2[Int, Int]] = {
    val head = currentLines.head
    val tail = currentLines.tail

    if (tail.isEmpty) {
      currentSeq ++ extractAsterisks(row, 0, head, Seq())
    }
    else {
      readLine(currentSeq ++ extractAsterisks(row, 0, head, Seq()), row+1, tail)
    }
  }

  private def extractAsterisks(r: Int, c: Int, line: String, currentSeq: Seq[Tuple2[Int, Int]]) : Seq[Tuple2[Int, Int]] = {
    val head = line.headOption
    val tail = line.tail

    if (tail.isEmpty) {
      head match {
        case Some('*') => currentSeq ++ Seq((r, c))
        case _ => currentSeq
      }
    }
    else {
      head match {
        case Some('*') => extractAsterisks(r, c+1, tail, currentSeq ++ Seq((r, c)))
        case _ => extractAsterisks(r, c+1, tail, currentSeq)
      }
    }
  }
}
