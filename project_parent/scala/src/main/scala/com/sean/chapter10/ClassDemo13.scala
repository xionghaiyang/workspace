package com.sean.chapter10

object ClassDemo13 {
  def main(args: Array[String]): Unit = {
    val names: List[String] = List("张三", "李四", "王五")
    val ages: List[Int] = List(23, 24, 25)
    val list1: List[(String, Int)] = names.zip(ages)
    val tuple1: (List[String], List[Int]) = list1.unzip
    println(s"拉链:$list1")
    println(s"拉开:$tuple1")
  }
}
