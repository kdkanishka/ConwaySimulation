package com.kani.gameoflife

import com.kani.utils.CellHelper
import org.scalatest.funsuite.AnyFunSuite

/**
 * Rules https://playgameoflife.com/info
 */
class BasicRulesTest extends AnyFunSuite with CellHelper{

  test("Each cell with one or no neighbors dies, as if by solitude."){
    val m1 = Array.ofDim[Cell](3, 3)

    //set initial cells
    newCell(m1,0,0,true)
    newCell(m1,1,1,true)

    val cellSpace = new CellSpace(m1)
    val m2 = cellSpace.getNextCellSpace()

    val points = toPoints(m2)

    assert(points.length == 0)
  }

  test("Each cell with four or more neighbors dies, as if by overpopulation."){
    val m1 = Array.ofDim[Cell](3, 3)

    //set initial cells
    newCell(m1,0,0,true)
    newCell(m1,2,0,true)
    newCell(m1,0,1,true)
    newCell(m1,1,1,true)
    newCell(m1,1,2,true)
    newCell(m1,2,2,true)

    val cellSpace = new CellSpace(m1)
    val m2 = cellSpace.getNextCellSpace()
    val points = toPoints(m2)

    assert(points.length == 5)
    assert(m2(0)(0).isAlive())
    assert(m2(1)(0).isAlive())
    assert(m2(2)(0).isAlive())
    assert(m2(2)(1).isAlive())
    assert(m2(2)(2).isAlive())
  }

  test("Each cell with two or three neighbors survives."){
    val m1 = Array.ofDim[Cell](3, 3)
    //set initial cells
    newCell(m1,0,0,true)
    newCell(m1,1,1,true)
    newCell(m1,1,2,true)

    val cellSpace = new CellSpace(m1)
    val m2 = cellSpace.getNextCellSpace()
    val points = toPoints(m2)

    assert(points.length == 2)

    assert(m2(1)(0).isAlive())
    assert(m2(1)(1).isAlive())

  }

  test("Each cell with three neighbors becomes populated."){
    val m1 = Array.ofDim[Cell](3, 3)
    //set initial cells
    newCell(m1,0,0,true)
    newCell(m1,0,1,true)
    newCell(m1,2,2,true)

    val cellSpace = new CellSpace(m1)
    val m2 = cellSpace.getNextCellSpace()
    val points = toPoints(m2)

    assert(points.length == 1)
    assert(m2(1)(1).isAlive())
  }
}
