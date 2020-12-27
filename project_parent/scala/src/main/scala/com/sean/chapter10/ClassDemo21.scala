package com.sean.chapter10

import scala.collection.mutable

object ClassDemo21 {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.Map
    val map1: Map[String, Int] = Map("张三" -> 23, "李四" -> 24)
    println(map1.get("张三"))
    println(map1.keys)
    println(map1.values)
    for ((k, v) <- map1) println(s"键:${k}，值：${v}")
    println("-" * 15)
    println(map1.getOrElse("王五", -1))
    println("-" * 15)
    println(s"map1:${map1}")
    //val map2: mutable.Map[String, Int] = map1+("王五" -> 25)
    val map2: Map[String, Int] = map1 + ("王五" -> 25)
    println(s"map2:${map2}")
    map1 -= "李四"
    println(s"map1:${map1}")
  }
}
