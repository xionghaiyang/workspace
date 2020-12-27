package com.sean.chapter11

object ClassDemo07 {
  def main(args: Array[String]): Unit = {
    val a: Any = (1, 2, 3)
    val b: Any = (3, 4, 5)
    val c: Any = (3, 4)

    a match {
      case (1, x, y) => println(s"匹配：长度为3，以1开头，后两个元素无所谓的元组，这里后两个元素是:${x},${y}")
      case (x, y, 5) => println(s"匹配：长度为3，以5结尾，前两个元素无所谓的元素，这里前两个元素是：${x},${y}")
      case _ => println("未匹配")
    }

    b match {
      case (1, x, y) => println(s"匹配：长度为3，以1开头，后两个元素无所谓的元组，这里后两个元素是:${x},${y}")
      case (x, y, 5) => println(s"匹配：长度为3，以5结尾，前两个元素无所谓的元素，这里前两个元素是：${x},${y}")
      case _ => println("未匹配")
    }

    c match {
      case (1, x, y) => println(s"匹配：长度为3，以1开头，后两个元素无所谓的元组，这里后两个元素是:${x},${y}")
      case (x, y, 5) => println(s"匹配：长度为3，以5结尾，前两个元素无所谓的元素，这里前两个元素是：${x},${y}")
      case _ => println("未匹配")
    }
  }
}
