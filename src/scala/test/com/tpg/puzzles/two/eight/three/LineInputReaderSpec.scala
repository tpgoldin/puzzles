package com.tpg.puzzles.two.eight.three

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class LineInputReaderSpec extends AnyFlatSpec with should.Matchers {
  "Input line reader" should "read problem input from lines" in {
    val lines = List("2", "14", "3", "3", "4", "8", "100", "4", "12", "15", "25", "40")

    val reader = InputLineReader(lines)

    reader.testCaseSpecs should contain theSameElementsAs Seq(TestCaseSpec(14, 3, List(3, 4, 8)),
      TestCaseSpec(100, 4, List(12, 15, 25, 40))).flatten
  }

  "it" should "not generate test case specs if count does not match number of test case specs" in {
    val lines = List("3", "14", "3", "3", "4", "8", "100", "4", "12", "15", "25", "40")

    val reader = InputLineReader(lines)

    reader.testCaseSpecs.isEmpty should be (true)
  }
}
