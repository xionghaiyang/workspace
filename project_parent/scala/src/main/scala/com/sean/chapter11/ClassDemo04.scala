package com.sean.chapter11

object ClassDemo04 {

  case class Customer(var name: String, var age: Int)

  case class Order(id: Int)

  def main(args: Array[String]): Unit = {
    val c: Any = Customer("糖糖", 73)
    val o: Any = Order(123)
    val arr: Any = Array(0, 1)
    c match {
      case Customer(a, b) => println(s"Customer类型的对象，name=${a},age=${b}")
      case Order(c) => println(s"Order类型,id=${c}")
      case _ => println("未匹配")
    }
    o match {
      case Customer(a, b) => println(s"Customer类型的对象，name=${a},age=${b}")
      case Order(c) => println(s"Order类型,id=${c}")
      case _ => println("未匹配")
    }
    arr match {
      case Customer(a, b) => println(s"Customer类型的对象，name=${a},age=${b}")
      case Order(c) => println(s"Order类型,id=${c}")
      case _ => println("未匹配")
    }
  }
}
