package com.sean.chapter6

object ClassDemo02 {

  class Person(val name: String = "张三", val age: Int = 23) {
    println("调用主构造器...")
  }

  class Customer(var name: String, var address: String) {
    def this(arr: Array[String]) {
      this(arr(0), arr(1))
    }
  }

  object Dog {
    val leg_num = 4
  }

  object PrintUtil {
    def printSpliter() = println("-" * 15)

    def main(args: Array[String]): Unit = {
      println("hello,scala")
    }
  }

  def main(args: Array[String]): Unit = {
    val p1: Person = new Person()
    println(s"p1:${p1.name}...${p1.age}")

    val p2: Person = new Person("李四", 24)
    println(s"p2:${p2.name}...${p2.age}")

    val p3: Person = new Person(age = 30)
    println(s"p3:${p3.name}...${p3.age}")

    val c: Customer = new Customer(Array("张三", "北京"))
    println(c.name, c.address)

    println(Dog.leg_num)

    PrintUtil.printSpliter()
    //PrintUtil.main(Array())
  }
}
