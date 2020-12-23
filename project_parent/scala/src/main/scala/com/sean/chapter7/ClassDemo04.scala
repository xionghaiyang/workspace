package com.sean.chapter7

object ClassDemo04 {

  class Person {
    var name = "张三"
    val age = 23

    def sayHello(): Unit = {
      println("Hello,Person!...")
    }
  }

  class Student extends Person {
    //override var name: String = "李四"
    override val age: Int = 24

    override def sayHello(): Unit = {
      super.sayHello()
      println("Hello,Student!...")
    }
  }

  def main(args: Array[String]): Unit = {
    val s: Student = new Student
    println(s.name,s.age)
    s.sayHello()
  }


}
