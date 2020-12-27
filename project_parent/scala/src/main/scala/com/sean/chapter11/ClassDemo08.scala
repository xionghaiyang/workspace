package com.sean.chapter11

object ClassDemo08 {
  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = (1 to 10).toArray
    val Array(_, x, y, z, _*) = arr
    println(x, y, z)
    println("-" * 15)

    val list: List[Int] = (0 to 10).toList
    val List(a, b, _ *) = list
    val c :: d :: tail = list
    println(a, b)
    println(c, d)
  }
}
