package com.sean.chapter7

object ClassDemo08 {

  abstract class Person {
    val occupation: String
  }

  class Student extends Person {
    override val occupation: String = "学生"
  }

  class Teacher extends Person {
    override val occupation: String = "老师"
  }

  def main(args: Array[String]): Unit = {
    val s: Student = new Student
    println(s.occupation)
    val t: Teacher = new Teacher
    println(t.occupation)
  }

}
