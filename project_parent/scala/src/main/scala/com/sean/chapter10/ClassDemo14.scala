package com.sean.chapter10

object ClassDemo14 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4)
    println(list1.toString)
    println(list1)
    println("-" * 15)
    println(list1.mkString(":"))
  }
}
