package com.sean.chapter7

object ClassDemo03 {

  class Person {
    var name = ""

    def sayHello() = println("Hello,Scala!..")
  }

  object Student extends Person

  def main(args: Array[String]): Unit = {
    Student.name = "张三"
    println(Student.name)
    Student.sayHello()
  }

}
