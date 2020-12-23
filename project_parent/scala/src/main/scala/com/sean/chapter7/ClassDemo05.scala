package com.sean.chapter7

object ClassDemo05 {

  class Person

  class Student extends Person {
    def sayHello() = println("Hello,Scala!...")
  }

  def main(args: Array[String]): Unit = {
    val p: Person = new Student
    if (p.isInstanceOf[Student]) {
      val s: Student = p.asInstanceOf[Student]
      s.sayHello()
    }
  }

}
