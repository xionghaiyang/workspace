package com.sean.chapter10

object ClassDemo22 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4, 5)
    val it: Iterator[Int] = list1.iterator
    while (it.hasNext) {
      println(it.next())
    }
    println("-" * 15)
    println(it.next())
  }
}
