package com.kani.draw

import java.awt.{Canvas, Color, Graphics, Point}

/**
 *
 * @param x    number of tiles in x axis
 * @param y    number of tiles in the y axis
 * @param size size of a tile
 */
class Surface(x: Int, y: Int, size: Int) extends Canvas {
  var positions = List[Point]()

  def setPositions(posList: List[Point]): Unit = {
    positions = posList
  }

  override def paint(g: Graphics): Unit = {
    setBackground(Color.WHITE);
    setForeground(Color.BLUE);

    val width = size * x
    val height = size * y

    g.clearRect(0, 0, width, height)
    g.drawRect(0, 0, width, height)

    positions.map {
      pos => g.fillRect(pos.x * size, pos.y * size, size, size)
    }

  }
}
