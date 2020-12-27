package com.sean.chapter11

object ClassDemo05 {
  def main(args: Array[String]): Unit = {
    val arr1: Array[Int] = Array(1, 2, 3)
    val arr2: Array[Int] = Array(0)
    val arr3: Array[Int] = Array(1, 2, 3, 4, 5)
    arr1 match {
      case Array(1, x, y) => println(s"匹配长度为3，首元素为1，后两个元素是：${x},${y}")
      case Array(0) => println("匹配：只有一个0元素的元组")
      case Array(1, _*) => println("匹配：第一个元素是1，后面元素为u所谓的数组")
      case _ => println("未匹配")
    }
    arr2 match {
      case Array(1, x, y) => println(s"匹配长度为3，首元素为1，后两个元素是：${x},${y}")
      case Array(0) => println("匹配：只有一个0元素的元组")
      case Array(1, _*) => println("匹配：第一个元素是1，后面元素为u所谓的数组")
      case _ => println("未匹配")
    }
    arr3 match {
      case Array(1, x, y) => println(s"匹配长度为3，首元素为1，后两个元素是：${x},${y}")
      case Array(0) => println("匹配：只有一个0元素的元组")
      case Array(1, _*) => println("匹配：第一个元素是1，后面元素为u所谓的数组")
      case _ => println("未匹配")
    }
  }
}
