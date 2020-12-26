package com.sean.chapter9

object ClassDemo04 {
  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = Array(1, 2, 3, 4, 5)
    for (i <- 0 to arr.length - 1) println(arr(i))
    println("-" * 15)
    for (i <- 0 until arr.length) println(arr(i))
    println("-" * 15)
    for (i <- arr) println(i)
  }
}
