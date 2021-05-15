package com.kani.main

import com.kani.Surface

import java.awt.Point
import javax.swing.{JFrame, WindowConstants}

object DrawTest extends App {
  val surface = new Surface(32, 32, 16)
  val f = new JFrame()
  f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  f.setSize(1024, 768)
  f.add(surface)
  f.setVisible(true)

  surface.setPositions(List(new Point(0,0), new Point(2,1), new Point(5,10),new Point(31,31)))
  surface.repaint()

  Thread.sleep(1000)

  surface.setPositions(List(new Point(1,1), new Point(4,2), new Point(6,11),new Point(30,30)))
  surface.repaint()
}

