package com.sean.chapter7

object ClassDemo10 {

  abstract class Animal {
    var name = ""
    var age = 0

    def run() = println("动物回跑步!...")

    def eat(): Unit
  }

  class Cat extends Animal {
    override def eat(): Unit = println("猫吃鱼")

    def catchMouse() = println("猫会抓老鼠")
  }

  class Dog extends Animal {
    override def eat(): Unit = println("狗吃肉")

    def lookHome() = println("狗会看家")
  }

  def main(args: Array[String]): Unit = {
    val c: Cat = new Cat
    c.name = "汤姆"
    c.age = 13
    println(c.name, c.age)
    if (c.isInstanceOf[Cat]) {
      val cat: Cat = c.asInstanceOf[Cat]
      cat.catchMouse()
    } else if (c.isInstanceOf[Dog]) {
      val dog: Dog = c.asInstanceOf[Dog]
      dog.lookHome()
    } else {
      println("您传入的不是猫类，也不是狗类对象")
    }
  }

}
