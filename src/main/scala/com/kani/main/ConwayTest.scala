package com.kani.main

import com.kani.draw.Surface
import com.kani.gameoflife.{Cell, CellSpace}
import com.kani.main.DrawTest.{getRandomPoints, surface}
import com.kani.utils.CellHelper
import org.apache.commons.lang3.RandomUtils

import java.awt.Point
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{JFrame, Timer, WindowConstants}

object ConwayTest extends App with CellHelper {
  val surface = new Surface(32, 32, 16)
  val f = new JFrame()
  f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  f.setSize(1024, 768)
  f.add(surface)
  f.setVisible(true)

  val m1 = Array.ofDim[Cell](32, 32)
//  newCell(m1, 0, 0, false)
//  newCell(m1, 0, 1, true)
//  newCell(m1, 1, 0, true)
//  newCell(m1, 1, 1, true)

//  newCell(m1, 10, 5, true)
//  newCell(m1, 10, 6, true)
//  newCell(m1, 10, 7, true)

  newCell(m1, 20, 20, true)
  newCell(m1, 22, 20, true)
  newCell(m1, 21, 21, true)
  newCell(m1, 22, 21, true)
  newCell(m1, 21, 22, true)
  newCell(m1, 22, 22, true)

//  newCell(m1,0,1,true)
//  newCell(m1,1,2,true)
//  newCell(m1,2,0,true)
//  newCell(m1,2,2,true)
//  newCell(m1,3,1,true)

  var cellSpace = new CellSpace(m1)
  surface.setPositions(toPoints(m1))
  surface.repaint()

  //  val newCells = cellSpace.getNextCellSpace()
  //  surface.setPositions(toPoints(newCells))
  //  surface.repaint()
  //
  //  cellSpace = new CellSpace(newCells)

  var counter = 0
  val endCounter = 10

  val timer = new Timer(1000, new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      if (endCounter == counter) {
        e.getSource().asInstanceOf[Timer].stop()
        println("Stop")
      }
      counter = counter + 1


      val newCells = cellSpace.getNextCellSpace()
      surface.setPositions(toPoints(newCells))
      surface.repaint()

      cellSpace = new CellSpace(newCells)
    }
  })
  timer.start()

}