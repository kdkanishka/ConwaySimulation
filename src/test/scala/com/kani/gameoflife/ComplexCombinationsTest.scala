package com.kani.gameoflife

import com.kani.utils.CellHelper
import org.scalatest.funsuite.AnyFunSuite

class ComplexCombinationsTest  extends AnyFunSuite with CellHelper{

  test("ssss"){
    val m1 = Array.ofDim[Cell](4, 4)

    //set initial cells
    newCell(m1,0,1,true)
    newCell(m1,1,2,true)
    newCell(m1,2,0,true)
    newCell(m1,2,2,true)
    newCell(m1,3,1,true)

    val cellSpace = new CellSpace(m1)
    val m2 = cellSpace.getNextCellSpace()
    val points = toPoints(m2)

    assert(points.length == 3)

    assert(m2(2)(1).isAlive())
    assert(m2(2)(2).isAlive())
    assert(m2(1)(3).isAlive())

  }
}
