package com.sean.chapter8

object ClassDemo05 {

  trait Logger {
    def log(msg: String) = println(msg)
  }

  class User

  def main(args: Array[String]): Unit = {
    val c1: User with Logger = new User with Logger
    c1.log("我是User类的对象，我可以调用Logger特质中的log方法了")
  }

}
