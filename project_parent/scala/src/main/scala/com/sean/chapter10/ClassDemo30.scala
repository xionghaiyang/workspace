package com.sean.chapter10

object ClassDemo30 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(2, 3, 1, 6, 4, 5)
    val list2: List[Int] = list1.sortWith(_ > _)
    println(s"list2:${list2}")
  }
}
