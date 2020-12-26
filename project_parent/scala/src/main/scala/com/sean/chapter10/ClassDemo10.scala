package com.sean.chapter10

import scala.collection.mutable.ListBuffer

object ClassDemo10 {
  def main(args: Array[String]): Unit = {
    val list1: ListBuffer[Int] = ListBuffer(1, 2, 3)
    println(list1(0))
    list1 += 4
    list1 ++= List(5, 6, 7)
    list1 -= 7
    list1 --= List(3, 4)
    val list2: List[Int] = list1.toList
    val arr: Array[Int] = list1.toArray
    println(s"list1:${list1}")
    println(s"list2:${list2}")
    println(s"arr:${arr.toBuffer}")
  }
}
