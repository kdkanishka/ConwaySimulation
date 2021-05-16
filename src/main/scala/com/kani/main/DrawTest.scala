package com.kani.main

import com.kani.draw.Surface
import org.apache.commons.lang3.RandomUtils

import java.awt.Point
import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{JFrame, Timer, WindowConstants}

object DrawTest extends App {
  val surface = new Surface(32, 32, 16)
  val f = new JFrame()
  f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  f.setSize(1024, 768)
  f.add(surface)
  f.setVisible(true)

  val timer = new Timer(200, new ActionListener {
    override def actionPerformed(e: ActionEvent): Unit = {
      surface.setPositions(getRandomPoints(500,32,32))
      surface.repaint()
    }
  })
  timer.start()


  def getRandomPoints(n : Int, maxX : Int, maxY : Int) : List[Point] = {
    List.range(0, n).map{
      id => {
        val x = RandomUtils.nextInt(0,maxX)
        val y = RandomUtils.nextInt(0,maxY)
        new Point(x,y)
      }
    }
  }
}


