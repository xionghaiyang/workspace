package com.sean.chapter9

object ClassDemo12 {
  def main(args: Array[String]): Unit = {
    val list1: List[List[Int]] = List(List(1, 2), List(3), List(4, 5))
    val list2: List[Int] = list1.flatten
    println(list2)
  }
}
