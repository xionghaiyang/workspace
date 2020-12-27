package com.sean.chapter10

object ClassDemo16 {
  def main(args: Array[String]): Unit = {
    val set1: Set[Int] = Set[Int]()
    val set2: Set[Int] = Set(1, 1, 3, 2, 4, 8)
    println(s"set1:${set1}")
    println(s"set2:${set2}")
  }
}
