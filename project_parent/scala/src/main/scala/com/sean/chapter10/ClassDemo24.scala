package com.sean.chapter10

object ClassDemo24 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4)
    list1.foreach((x: Int) => println(x))
    println("-" * 15)
    list1.foreach(x => println(x))
    println("-" * 15)
    list1.foreach(println(_))
  }
}
