package com.sean.chapter10

object ClassDemo20 {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable,mutable.Map
    val map1: Map[String, Int] = Map("张三"->23,"李四"->24)
    val map2: Map[String, Int] = Map(("张三",23),("李四",24))
    map1("张三")=30
    println(s"map1:${map1}")
    println(s"map2:${map2}")
  }
}
