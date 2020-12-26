package com.sean.chapter9

object ClassDemo07 {
  def main(args: Array[String]): Unit = {
    val tuple1: (String, String) = "zhangsan" -> "male"
    println(s"姓名:${tuple1._1},性别:${tuple1._2}")
    val it: Iterator[Any] = tuple1.productIterator
    for (i <- it) println(i)
  }
}
