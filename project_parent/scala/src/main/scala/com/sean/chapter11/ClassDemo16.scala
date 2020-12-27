package com.sean.chapter11

object ClassDemo16 {
  def main(args: Array[String]): Unit = {
    try {
      val i: Int = 10 / 0
    } catch {
      case e: Exception => e.printStackTrace()
        println("你好")
        println("-" * 15)
        throw new Exception("我是一个Bug！")
        println("Hello,Scala!")
    }
  }
}
