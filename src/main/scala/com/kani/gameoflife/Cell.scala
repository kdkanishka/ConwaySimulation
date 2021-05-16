package com.kani.gameoflife

import java.awt.Point
import scala.collection.mutable.ArrayBuffer
import scala.util.Try

case class Cell(p: Point, al: Boolean = false) {
  private var alive = al

  def isAlive(): Boolean = {
    alive
  }

  def letDie(): Unit = {
    alive = false
  }

  def letPopulate(): Unit = {
    alive = true
  }

  def getNeighbourCells(alive: Boolean, m: Array[Array[Cell]]): List[Cell] = {
    val nx = p.x
    val ny = p.y
    //TODO fix here
    //    val neighbourCells = List(
    //      Cell(new Point(nx - 1, ny - 1)),
    //      Cell(new Point(nx, ny - 1)),
    //      Cell(new Point(nx + 1, ny - 1)),
    //      Cell(new Point(nx - 1, ny)),
    //      Cell(new Point(nx - 1, ny + 1)),
    //      Cell(new Point(nx, ny + 1)),
    //      Cell(new Point(nx + 1, ny + 1)),
    //    )

    //    val neighbourCells = List(
    //      m(ny - 1)(nx - 1),
    //      m(ny - 1)(nx),
    //      m(ny - 1)(nx + 1),
    //      m(ny)(nx - 1),
    //      m(ny + 1)(nx - 1),
    //      m(ny + 1)(nx),
    //      m(ny + 1)(nx + 1),
    //    )
/*
    val neighbours = ArrayBuffer[Cell]()
    neighbours.append(m(ny + 1)(nx))
    neighbours.append(m(ny + 1)(nx + 1))
    neighbours.append(m(ny)(nx + 1))

    if ((ny - 1) >= 0 && (nx - 1) >= 0) {
      neighbours.append(m(ny - 1)(nx - 1))
    }

    if ((ny - 1 >= 0)) {
      neighbours.append(m(ny - 1)(nx))
      neighbours.append(m(ny - 1)(nx + 1))
    }

    if ((nx - 1 >= 0)) {
      neighbours.append(m(ny)(nx - 1))
      neighbours.append(m(ny + 1)(nx - 1))
    }
    */
    val neighbours = ArrayBuffer[Cell]()
    Try{
      neighbours.append(m(ny + 1)(nx))
    }
    Try{
      neighbours.append(m(ny + 1)(nx + 1))
    }
    Try{
      neighbours.append(m(ny)(nx + 1))
    }
    Try{
      neighbours.append(m(ny - 1)(nx - 1))
    }
    Try {
      neighbours.append(m(ny - 1)(nx))
    }
    Try {
      neighbours.append(m(ny - 1)(nx + 1))
    }
    Try {
      neighbours.append(m(ny)(nx - 1))
    }
    Try {
      neighbours.append(m(ny + 1)(nx - 1))
    }


    var neighbourCells = neighbours.toList
    neighbourCells = neighbourCells.filter(cell => cell != null)


    if (alive) {
      neighbourCells.filter(cell => cell.isAlive())
    } else {
      neighbourCells
    }
  }
}
