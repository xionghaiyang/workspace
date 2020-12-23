package com.sean.chapter7

object ClassDemo09 {

  abstract class Person {
    def sayHello()
  }

  def show(p: Person) = p.sayHello()

  def main(args: Array[String]): Unit = {
    new Person {
      override def sayHello(): Unit = println("Hello,Scala,当对成员方法仅调用一次的时候.")
    }.sayHello()

    val p: Person = new Person {
      override def sayHello(): Unit = println("Hello,Scala,可以作为方法的实际参数进行传递")
    }
    show(p)
  }

}
