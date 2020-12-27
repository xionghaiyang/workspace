package com.sean.chapter10

object ClassDemo26 {
  def main(args: Array[String]): Unit = {
    val list1: List[String] = List("hadoop hive spark flink flume", "kudu hbase sqoop storm")
    val list2: List[Array[String]] = list1.map(_.split(" "))
    val list3: List[String] = list2.flatten
    println(s"list3:${list3}")
    val list4: List[String] = list1.flatMap(_.split(" "))
    println(s"list4:${list4}")
  }
}
