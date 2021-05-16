package com.kani.utils

import com.kani.gameoflife.Cell

import java.awt.Point

trait CellHelper {
  def newCell(m: Array[Array[Cell]], x: Int, y: Int, alive: Boolean): Unit = {
    m(y)(x) = Cell(new Point(x, y), alive)
  }

  def toPoints(m: Array[Array[Cell]]): List[Point] = {
    val allCells = for {
      rows <- m
      cells <- rows
    } yield cells

    val nonEmptyCells = allCells.filter(ce => ce != null)

    val liveCells = nonEmptyCells.filter(c => c.isAlive())

    val drawableCells = for {
      cell <- liveCells
    } yield cell.p

    drawableCells.toList
  }
}
