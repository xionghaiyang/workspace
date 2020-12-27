package com.sean.chapter11

import scala.io.StdIn

object ClassDemo03 {
  def main(args: Array[String]): Unit = {
    println("请输入一个整数:")
    val num: Int = StdIn.readInt()
    num match {
      case a if a >= 0 && a <= 3 => println("[0-3]")
      case a if a >= 4 && a <= 8 => println("[4-8]")
      case _ => println("未匹配")
    }
  }
}
