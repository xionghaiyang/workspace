package com.sean.chapter11

object ClassDemo10 {
  def div(a: Int, b: Int) = {
    if (b == 0) {
      None
    } else {
      Some(a / b)
    }
  }

  def main(args: Array[String]): Unit = {
    val result: Option[Int] = div(10, 0)
    result match {
      case Some(x) => println(x)
      case None => println("除数不能为0")
    }
    println("-" * 15)
    println(result.getOrElse(0))
  }
}
