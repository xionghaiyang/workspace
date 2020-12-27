package com.sean.chapter10

object ClassDemo17 {
  def main(args: Array[String]): Unit = {
    val set1: Set[Int] = Set(1, 1, 2, 3, 4, 5)
    println(s"set1的长度为:${set1.size}")
    println("set1集中的元素为:")
    for (i <- set1) println(i)
    println("-" * 15)

    val set2: Set[Int] = set1 - 1
    println(s"set2:${set2}")
    val set3: Set[Int] = set1 ++ Set(6, 7, 8)
    println(s"set3:${set3}")
    val set4: Set[Int] = set1++List(6,7,8,9)
    println(s"set4:${set4}")
  }
}
