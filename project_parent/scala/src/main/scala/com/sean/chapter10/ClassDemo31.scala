package com.sean.chapter10

object ClassDemo31 {
  def main(args: Array[String]): Unit = {
    val list1: List[(String, String)] = List("刘德华" -> "男", "刘亦菲" -> "女", "胡歌" -> "男")
    val list2: Map[String, List[(String, String)]] = list1.groupBy(_._2)
    println(s"list2:${list2}")
    val list3: Map[String, Int] = list2.map(x => x._1 -> x._2.size)
    println(s"list3:${list3}")
  }
}
