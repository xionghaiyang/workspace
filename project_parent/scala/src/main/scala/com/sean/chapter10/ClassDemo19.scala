package com.sean.chapter10

object ClassDemo19 {
  def main(args: Array[String]): Unit = {
    val map1: Map[String, Int] = Map("张三"->23,"李四"->24,"李四"->40)
    val map2: Map[String, Int] = Map(("张三",23),("李四",24),("李四",40))
    println(s"map1:${map1}")
    println(s"map2:${map2}")
  }
}
