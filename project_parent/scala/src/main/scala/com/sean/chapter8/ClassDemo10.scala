package com.sean.chapter8

object ClassDemo10 {

  class Message {
    def printMsg()=println("学好Scala，走到哪里都不怕！")
  }

  trait Logger extends Message

  class ConsoleLogger extends Logger

  def main(args: Array[String]): Unit = {
    val c1: ConsoleLogger = new ConsoleLogger
    c1.printMsg()
  }
}
