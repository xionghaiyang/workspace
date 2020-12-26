package com.sean.chapter9

object ClassDemo05 {
  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = Array(4, 1, 6, 5, 2, 3)
    println(s"sum:${arr.sum}")
    println(s"max:${arr.max}")
    println(s"min:${arr.min}")
    val arr2: Array[Int] = arr.sorted
    val arr3: Array[Int] = arr.sorted.reverse
    for (i <- arr) println(i)
    for (i <- arr2) println(i)
    for (i <- arr3) println(i)
  }
}
