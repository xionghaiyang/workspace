package com.sean.chapter10

object ClassDemo29 {
  def main(args: Array[String]): Unit = {
    val list1: List[String] = List("01 hadoop", "02 flume", "04 spark", "03 hive")
    val list2: List[String] = list1.sortBy(_.split(" ")(0))
    println(s"list2:${list2}")
  }
}
