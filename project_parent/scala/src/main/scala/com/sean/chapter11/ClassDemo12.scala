package com.sean.chapter11

object ClassDemo12 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = (1 to 10).toList
    val list2: List[String] = list1.map {
      case x if x >= 1 && x <= 3 => "[1-3]"
      case x if x >= 4 && x <= 8 => "[4-8]"
      case _ => "(8-*]"
    }
    println(list2)
  }
}
