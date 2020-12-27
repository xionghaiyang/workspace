package com.sean.chapter11

import scala.io.StdIn

object ClassDemo18 {
  def main(args: Array[String]): Unit = {
    println("请录入一个数字（1-5）,我来告诉您上辈子的职业")
    val num: Int = StdIn.readInt()
    val occupation: String = num match {
      case 1 => "一品带刀侍卫"
      case 2 => "宰相"
      case 3 => "江湖郎中"
      case 4 => "打铁匠"
      case 5 => "店小二"
      case _ => "公公"
    }
    println(s"您上辈子的职业是：${occupation}")
  }
}
