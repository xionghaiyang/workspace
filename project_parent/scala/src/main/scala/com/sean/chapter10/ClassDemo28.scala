package com.sean.chapter10

object ClassDemo28 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(3, 1, 2, 9, 7)
    val list2: List[Int] = list1.sorted
    println(s"list2:${list2}")
    val list3: List[Int] = list2.reverse
    println(s"list3:${list3}")
  }
}
