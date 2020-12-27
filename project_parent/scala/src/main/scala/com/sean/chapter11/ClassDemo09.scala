package com.sean.chapter11

object ClassDemo09 {
  def main(args: Array[String]): Unit = {
    val map1: Map[String, Int] = Map("张三" -> 23, "李四" -> 24, "王五" -> 23, "赵六" -> 26)
    for ((k, v) <- map1 if v == 23) println(s"${k}=${v}")
    println("-" * 15)
    for ((k, 23) <- map1) println(s"${k}=23")
  }
}
