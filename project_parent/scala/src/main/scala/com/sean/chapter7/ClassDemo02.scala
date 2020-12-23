package com.sean.chapter7

object ClassDemo02 {

  class Person {
    var name = ""
    var age = 0

    def eat() = println("人要吃饭！...")
  }

  class Teacher extends Person

  class Student extends Person

  def main(args: Array[String]): Unit = {
    val t: Teacher = new Teacher
    t.name = "刘老师"
    t.age = 32
    println(t.name, t.age)
    t.eat()

    println("-" * 15)

    val s: Student = new Student
    s.name = "张三"
    s.age = 23
    println(s.name, s.age)
    s.eat()

  }

}
