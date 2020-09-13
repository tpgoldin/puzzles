package com.tpg.puzzles.one.six.two

import scala.collection.immutable.{SortedMap, TreeMap}

class ProblemSolver(val lines: Seq[String]) {
  private val grid = new Grid(lines)
  private val counter = new Counter(grid)
  val dims = grid.size

  def solve() : SortedMap[Tuple2[Int, Int], AsteriskOrCount] = {
    val rows = 0 until dims._1
    val cols = 0 until dims._2

    processRows(rows, cols, new TreeMap())
  }

  private def processRows(rows: Range, cols: Range, currentMap: SortedMap[Tuple2[Int, Int], AsteriskOrCount]) : SortedMap[Tuple2[Int, Int], AsteriskOrCount] = {
    val head = rows.head
    val tail = rows.tail

    if (tail.nonEmpty) {
      val newMap = processCols(head, cols, currentMap)

      processRows(tail, cols, newMap)
    }
    else {
      processCols(head, cols, currentMap)
    }
  }

  private def processCols(r: Int, cols: Range, currentMap: Map[Tuple2[Int, Int], AsteriskOrCount]) : SortedMap[Tuple2[Int, Int], AsteriskOrCount] = {
    val head = cols.head
    val tail = cols.tail

    if (tail.nonEmpty) {
      val newMap = processCell(r, head) ++ currentMap
      processCols(r, tail, newMap)
    }
    else {
      processCell(r, head) ++ currentMap
    }
  }

  private def processCell(r: Int, c: Int): SortedMap[Tuple2[Int, Int], AsteriskOrCount] = {
    val cell = (r, c)

    val value = if (grid(cell)) {
      new AsteriskOrCount
    }
    else {
      val count = counter(cell)
      new AsteriskOrCount(count)
    }

    TreeMap(cell -> value)
  }
}

object ProblemSolver {

  def main(args: Array[String]): Unit = {
    val lines = processLine(io.Source.stdin.getLines, Seq())

    val solver = new ProblemSolver(lines.toList)

    val solved = solver.solve

    val byRows = solved.groupBy(_._1._1)

    val dims = solver.dims

    val rows = 0 until (dims._1)
    val cols = 0 until (dims._2)

    val output = processRows(rows, cols, byRows, "")

    println(s"$output")
  }

  private def processLine(strings: Iterator[String], currentSeq: Seq[String]) : Seq[String] = {
    if (strings.hasNext) {
      val value = strings.next
      if (!value.isBlank) {
        processLine(strings, Seq(value) ++ currentSeq)
      }
      else {
        currentSeq
      }
    }
    else {
      currentSeq
    }
  }

  private def processRows(rows: Range, cols: Range, byRows: Map[Int, SortedMap[Tuple2[Int, Int], AsteriskOrCount]], currentString: String) : String = {
    val head = rows.head
    val tail = rows.tail

    if (tail.nonEmpty) {
      val newValue = processCols(head, cols, byRows, currentString) + "\n"
      processRows(tail, cols, byRows, newValue)
    }
    else {
      processCols(head, cols, byRows, "") + "\n"
    }
  }

  private def processCols(r: Int, cols: Range, byRows: Map[Int, SortedMap[Tuple2[Int, Int], AsteriskOrCount]], currentString: String) : String = {
    val head = cols.head
    val tail = cols.tail

    if (!tail.nonEmpty) {
      val newString = processCol(r, head, byRows, currentString)
      processCols(r, tail, byRows, newString)
    }
    else {
      processCol(r, head, byRows, currentString)
    }
  }

  private def processCol(r: Int, c: Int, byRows: Map[Int, SortedMap[Tuple2[Int, Int], AsteriskOrCount]], currentString: String) : String = {
    val key = (r, c)
    val value = byRows(r)(key)

    currentString + value.toString
  }
}