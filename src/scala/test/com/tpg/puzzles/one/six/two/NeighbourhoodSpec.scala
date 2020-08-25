package com.tpg.puzzles.one.six.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class NeighbourhoodSpec extends AnyFlatSpec with should.Matchers {
  val grid = Tuple2(3, 4)

  "Neighbourhood" should "generate for the position (0, 0) the neighbourhood (0, 1), (1, 0), (1, 1)" in {
    val neighbourhood = new Neighbourhood(grid, 0, 0)

    neighbourhood.values should contain theSameElementsAs Vector((0, 1), (1, 0), (1, 1))
  }

  it should "generate for the position (0, 1) the neighbourhood (0, 0), (0, 2), (1, 0), (1, 1), (1, 2)" in {
    val neighbourhood = new Neighbourhood(grid, 0, 1)

    neighbourhood.values should contain theSameElementsAs Vector((0, 0), (0, 2), (1, 0), (1, 1), (1, 2))
  }

  it should "generate for the position (0, 2) the neighbourhood (0, 1), (1, 1), (1, 2), (1, 3), (0, 3)" in {
    val neighbourhood = new Neighbourhood(grid, 0, 2)

    neighbourhood.values should contain theSameElementsAs Vector((0, 1), (1, 1), (1, 2), (1, 3), (0, 3))
  }

  it should "generate for the position (0, 3) the neighbourhood (0, 2), (1, 2), (1, 3)" in {
    val neighbourhood = new Neighbourhood(grid, 0, 3)

    neighbourhood.values should contain theSameElementsAs Vector((0, 2), (1, 2), (1, 3))
  }

  it should "generate for the position (1, 0) the neighbourhood (0, 0), (0, 1), (1, 1), (2, 0), (2, 1)" in {
    val neighbourhood = new Neighbourhood(grid, 1, 0)

    neighbourhood.values should contain theSameElementsAs Vector((0, 0), (0, 1), (1, 1), (2, 0), (2, 1))
  }

  it should "generate for the position (1, 1) the neighbourhood (0, 0), (0, 1), (0, 2), (1, 0), (1, 2), (2, 0), (2, 1), (2, 2)" in {
    val neighbourhood = new Neighbourhood(grid, 1, 1)

    neighbourhood.values should contain theSameElementsAs Vector((0, 0), (0, 1), (0, 2), (1, 0), (1, 2), (2, 0), (2, 1), (2, 2))
  }

  it should "generate for the position (1, 2) the neighbourhood (0, 1), (0, 2), (0, 3), (1, 1), (1, 3), (2, 1), (2, 2), (2, 3)" in {
    val neighbourhood = new Neighbourhood(grid, 1, 2)

    neighbourhood.values should contain theSameElementsAs Vector((0, 1), (0, 2), (0, 3), (1, 1), (1, 3), (2, 1), (2, 2), (2, 3))
  }

  it should "generate for the position (1, 3) the neighbourhood (0, 2), (0, 3), (1, 2), (2, 2), (2, 3)" in {
    val neighbourhood = new Neighbourhood(grid, 1, 3)

    neighbourhood.values should contain theSameElementsAs Vector((0, 2), (0, 3), (1, 2), (2, 2), (2, 3))
  }

  it should "generate for the position (2, 0) the neighbourhood (1, 0), (1, 1), (2, 1)" in {
    val neighbourhood = new Neighbourhood(grid, 2, 0)

    neighbourhood.values should contain theSameElementsAs Vector((1, 0), (1, 1), (2, 1))
  }

  it should "generate for the position (2, 1) the neighbourhood (1, 0), (2, 0), (1, 1), (1, 2), (2, 2)" in {
    val neighbourhood = new Neighbourhood(grid, 2, 1)

    neighbourhood.values should contain theSameElementsAs Vector((1, 0), (2, 0), (1, 1), (1, 2), (2, 2))
  }

  it should "generate for the position (2, 2) the neighbourhood (2, 1), (1, 1), (1, 2), (1, 3), (2, 3)" in {
    val neighbourhood = new Neighbourhood(grid, 2, 2)

    neighbourhood.values should contain theSameElementsAs Vector((2, 1), (1, 1), (1, 2), (1, 3), (2, 3))
  }

  it should "generate for the position (2, 3) the neighbourhood (2, 2), (1, 2), (1, 3)" in {
    val neighbourhood = new Neighbourhood(grid, 2, 3)

    neighbourhood.values should contain theSameElementsAs Vector((2, 2), (1, 2), (1, 3))
  }
}
