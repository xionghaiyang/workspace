package com.sean.chapter7

object ClassDemo06 {

  class Person

  class Student extends Person

  def main(args: Array[String]): Unit = {
    val p: Person = new Student
    println(p.isInstanceOf[Person])
    println(p.isInstanceOf[Student])
    println(p.getClass==classOf[Person])
    println(p.getClass==classOf[Student])
  }

}
