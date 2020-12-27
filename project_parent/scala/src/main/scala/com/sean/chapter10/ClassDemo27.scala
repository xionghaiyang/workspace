package com.sean.chapter10

object ClassDemo27 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = (1 to 9).toList
    val list2: List[Int] = list1.filter(_ % 2 == 0)
    println(s"list2:${list2}")
  }
}
