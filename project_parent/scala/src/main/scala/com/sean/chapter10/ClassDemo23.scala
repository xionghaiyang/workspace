package com.sean.chapter10

object ClassDemo23 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4)
    list1.foreach((x: Int) => println(x))
  }
}
