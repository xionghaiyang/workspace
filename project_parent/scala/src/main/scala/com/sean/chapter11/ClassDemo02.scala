package com.sean.chapter11

object ClassDemo02 {
  def main(args: Array[String]): Unit = {
    val a: Any = 1.0
    val result: String = a match {
      case x: String => s"${x}是String类型的数据"
      case x: Double => s"${x}是Double类型的数据"
      case x: Int => s"${x}是Int类型的数据"
      case _ => "未匹配"
    }
    println(result)
    val result2: String = a match {
      case _: String => "String"
      case _: Double => "Double"
      case _: Int => "Int"
      case _ => "未匹配"
    }
    println(result2)
  }
}
