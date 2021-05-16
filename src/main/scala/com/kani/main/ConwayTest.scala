package com.kani.main

import com.kani.draw.Surface
import com.kani.gameoflife.{Cell, CellSpace}
import com.kani.main.DrawTest.{getRandomPoints, surface}
import org.apache.commons.lang3.RandomUtils

import java.awt.Point
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{JFrame, Timer, WindowConstants}

object ConwayTest extends App {
  val surface = new Surface(32, 32, 16)
  val f = new JFrame()
  f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  f.setSize(1024, 768)
  f.add(surface)
  f.setVisible(true)

  val m1 = Array.ofDim[Cell](32,32)
  m1(0)(0) = Cell(new Point(0,0))
  m1(1)(0) = Cell(new Point(0,1),true)
  m1(0)(1) = Cell(new Point(1,0),true)
  m1(1)(1) = Cell(new Point(1,1),true)

  val cellSpace = new CellSpace(m1)

  val m2 = cellSpace.getNextCellSpace()

  surface.setPositions(toPoints(m1))
  surface.repaint()
  println("frame 1")

  Thread.sleep(500)

  surface.setPositions(toPoints(m2))
  surface.repaint()
  println("frame 2")

  println("Done")



  def toPoints(m : Array[Array[Cell]]) : List[Point] = {
    val ccl = for{
      xx <- m
      cc <- xx
    } yield cc

    val cells = ccl.filter(ce => ce != null)

    val liveCells = cells.filter(c => c.isAlive())

    val xxxxx = for{
      ccc <- liveCells
    }yield ccc.p

    xxxxx.toList
  }
}