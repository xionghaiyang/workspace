package com.sean.chapter9

import scala.collection.mutable.ListBuffer

object ClassDemo09 {
  def main(args: Array[String]): Unit = {
    val list1: ListBuffer[Int] = new ListBuffer[Int]()
    val list2: ListBuffer[Int] = ListBuffer(1, 2, 3, 4)
    println(s"list1:${list1}")
    println(s"list2:${list2}")
  }
}
