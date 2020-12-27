package com.sean.chapter11

object ClassDemo17 {

  class Student(var name: String, var age: Int)

  object Student {
    def apply(name: String, age: Int): Student = new Student(name, age)

    def unapply(s: Student): Option[(String, Int)] = {
      if (s != null) {
        Some(s.name, s.age)
      } else {
        None
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val s: Student = new Student("糖糖", 73)
    val s2: Student = Student("糖糖", 73)
    println(s"${s2.name}...${s2.age}")
    val result: Option[(String, Int)] = Student.unapply(s2)
    println(result)
  }
}
