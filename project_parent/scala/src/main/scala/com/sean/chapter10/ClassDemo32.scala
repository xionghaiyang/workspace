package com.sean.chapter10

object ClassDemo32 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = (1 to 10).toList
    val list2: Int = list1.reduce(_ + _)
    val list3: Int = list1.reduceLeft(_ + _)
    val list4: Int = list1.reduceRight(_ + _)
    println(s"list2:${list2}")
    println(s"list3:${list3}")
    println(s"list3:${list4}")
  }
}
