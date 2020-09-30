package com.tpg.puzzles.two.eight.three

import scala.annotation.tailrec

case class TestCaseSpec private(N: Int, P: Int, hps: List[Int]) {}

object TestCaseSpec {
  def apply(N: Int, P: Int, hps: List[Int]): Option[TestCaseSpec] = {
    if (P != hps.size) { return None }

    Some(new TestCaseSpec(N, P, hps))
  }
}

case class InputLineReader(input: List[String]) {

  def buildTestCaseSpecs(lines: List[String]): List[TestCaseSpec] = {

    buildTestCaseSpecs(lines, List())
  }

  @tailrec
  private def buildTestCaseSpecs(lines: List[String], specs: List[TestCaseSpec]) : List[TestCaseSpec] = {
    val N = lines(0).toInt
    val P = lines(1).toInt

    val nextLines = lines.drop(2)

    val hpLines = nextLines.take(P)

    val nextTestCaseSpecLines = nextLines.drop(P)

    val hps = hpLines.map(_.toInt)

    val newSpecs = TestCaseSpec(N, P, hps).map(specs ++ List(_)).getOrElse(specs)

    if (nextTestCaseSpecLines.isEmpty) { return newSpecs }

    buildTestCaseSpecs(nextTestCaseSpecLines, newSpecs)
  }

  lazy val testCaseSpecs : List[TestCaseSpec] = {
    val count = input.head.toInt

    val specs = buildTestCaseSpecs(input.tail)

    if (specs.size == count) { specs } else { List() }
  }
}
