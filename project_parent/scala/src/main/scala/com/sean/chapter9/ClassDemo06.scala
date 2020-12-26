package com.sean.chapter9

object ClassDemo06 {
  def main(args: Array[String]): Unit = {
    val tuple1: (String, Int) = ("张三",23)
    println(tuple1)
    val tuple2: (String, Int) = "张三"->23
    println(tuple2)
  }
}
