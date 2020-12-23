package com.sean.chapter7

object ClassDemo07 {

  abstract class Shape {
    def area: Double
  }

  class Square(var edge: Double) extends Shape {
    override def area: Double = edge * edge
  }

  class Rectange(var length: Double, var width: Double) extends Shape {
    override def area: Double = length * width
  }

  class Circle(var radius: Double) extends Shape {
    override def area: Double = Math.PI * radius * radius
  }

  def main(args: Array[String]): Unit = {
    val s1: Square = new Square(2)
    val s2: Rectange = new Rectange(2, 3)
    val s3: Circle = new Circle(2)
    println(s1.area)
    println(s2.area)
    println(s3.area)
  }

}
