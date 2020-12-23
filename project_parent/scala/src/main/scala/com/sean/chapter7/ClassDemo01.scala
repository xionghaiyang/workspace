package com.sean.chapter7

object ClassDemo01 {

  class Teacher {
    var name = ""
    var age = 0

    def eat() = println("老师喝牛肉汤！...")
  }

  class Student {
    var name = ""
    var age = 0

    def eat() = println("学生吃牛肉！...")
  }

  def main(args: Array[String]): Unit = {
    val t: Teacher = new Teacher
    t.name = "刘老师"
    t.age = 32
    println(t.name, t.age)
    t.eat()
    println("-" * 15)

    val s: Student = new Student
    s.name = "张三"
    s.age = 21
    println(s.name, s.age)
    s.eat()
  }

}
