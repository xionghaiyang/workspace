package com.sean.chapter10

object ClassDemo25 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4)
    val list2: List[String] = list1.map((x: Int) => "*" * x)
    println(s"list2:${list2}")
    val list3: List[String] = list1.map(x => "*" * x)
    println(s"list3:${list3}")
    val list4: List[String] = list1.map("*" * _)
    println(s"list4:${list4}")
  }
}
