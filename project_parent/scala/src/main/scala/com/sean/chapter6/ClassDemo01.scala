package com.sean.chapter6

object ClassDemo01 {

  class Person {
    var name: String = _
    var age: Int = 0
    var sex: String = ""

    def printHello(msg: String): Unit = {
      println(msg)
    }
  }

  class Customer {
    private var name = ""
    private var age = 0

    def getName(): String = name

    def setName(name: String): Unit = {
      this.name = name
    }

    def getAge(): Int = age

    def setAge(age: Int): Unit = {
      this.age = age
    }

    private def sayHello(): Unit = println("Hello,Scala")
  }

  def main(args: Array[String]): Unit = {
    val p: Person = new Person
    p.name = "张三"
    p.age = 23
    p.sex = "男"
    println(p.name, p.age, p.sex)
    p.printHello("你好")

    val c: Customer = new Customer
    c.setName("张三")
    c.setAge(23)
    println(c.getName(), c.getAge())
    //c.sayHello()
  }

}
