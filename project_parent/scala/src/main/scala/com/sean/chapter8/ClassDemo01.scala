package com.sean.chapter8

object ClassDemo01 {

  trait Logger {
    def log(msg: String)
  }

  class ConsoleLogger extends Logger {
    override def log(msg: String): Unit = println(msg)
  }

  def main(args: Array[String]): Unit = {
    val c1: ConsoleLogger = new ConsoleLogger
    c1.log("trait入门：类继承单个特质")
  }

}
