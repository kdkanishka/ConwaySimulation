package com.kani.gameoflife

import java.awt.Point

class CellSpace(m1: Array[Array[Cell]]) {
  val m2 = Array.ofDim[Cell](32,32)

  def getNextCellSpace(): Array[Array[Cell]] = {
    for (y <- 0 to m1.size - 1) { // Y axis
      val xSeq = m1(y)
      for (x <- 0 to xSeq.size - 1) {
        val cell = m1(y)(x)
        if (cell != null && canDie(cell)) {
          cell.letDie()
        }

        if(cell == null){
          val candidateCell = Cell(new Point(x,y))
          if(canPopulate(candidateCell)){
            candidateCell.letPopulate();
            m2(y)(x) = candidateCell
          }
        }else {
          if (!cell.isAlive() && canPopulate(cell)) {
            cell.letPopulate()
          }
        }

        m2(y)(x) = cell
      }
    }
    m2
  }

  /**
   * * Each cell with two or three neighbors survives.
   *
   * @param cell
   * @return
   */
  def canSurvive(cell: Cell): Boolean = {
    val neighbours = cell.getNeighbourCells(alive = true, m1).length
    neighbours == 2 || neighbours == 3
  }

  /**
   * * Each cell with one or no neighbors dies, as if by solitude.
   * * Each cell with four or more neighbors dies, as if by overpopulation.
   *
   * @param cell
   * @return
   */
  def canDie(cell: Cell): Boolean = {
    val neighbours = cell.getNeighbourCells(alive = true, m1).length
    neighbours <= 1 || neighbours >= 4
  }

  /**
   * * Each cell with three neighbors becomes populated.
   *
   * @param cell
   * @return
   */
  def canPopulate(cell: Cell): Boolean = {
    val neighbours = cell.getNeighbourCells(alive = true, m1).length
    neighbours == 3
  }

}
