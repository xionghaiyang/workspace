package com.sean.chapter11

object ClassDemo06 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(0)
    val list2: List[Int] = List(0, 1, 2, 3, 4, 5)
    val list3: List[Int] = List(1, 2)
    list1 match {
      case List(0) => println("匹配：只有一个0元素的列表")
      case List(0, _*) => println("匹配：0开头，后边元素无所谓的列表")
      case List(x, y) => println(s"匹配：只有两个元素的列表，元素为:${x},${y}")
      case _ => println("未匹配")
    }
    list1 match {
      case 0 :: Nil => println("匹配：只有一个0元素的列表")
      case 0 :: tail => println("匹配：0开头，后边元素无所谓的列表")
      case x :: y :: Nil => println(s"匹配：只有两个元素的列表，元素为:${x},${y}")
      case _ => println("未匹配")
    }

    list2 match {
      case List(0) => println("匹配：只有一个0元素的列表")
      case List(0, _*) => println("匹配：0开头，后边元素无所谓的列表")
      case List(x, y) => println(s"匹配：只有两个元素的列表，元素为:${x},${y}")
      case _ => println("未匹配")
    }
    list2 match {
      case 0 :: Nil => println("匹配：只有一个0元素的列表")
      case 0 :: tail => println("匹配：0开头，后边元素无所谓的列表")
      case x :: y :: Nil => println(s"匹配：只有两个元素的列表，元素为:${x},${y}")
      case _ => println("未匹配")
    }

    list3 match {
      case List(0) => println("匹配：只有一个0元素的列表")
      case List(0, _*) => println("匹配：0开头，后边元素无所谓的列表")
      case List(x, y) => println(s"匹配：只有两个元素的列表，元素为:${x},${y}")
      case _ => println("未匹配")
    }
    list3 match {
      case 0 :: Nil => println("匹配：只有一个0元素的列表")
      case 0 :: tail => println("匹配：0开头，后边元素无所谓的列表")
      case x :: y :: Nil => println(s"匹配：只有两个元素的列表，元素为:${x},${y}")
      case _ => println("未匹配")
    }
  }
}
