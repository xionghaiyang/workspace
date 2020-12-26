package com.sean.chapter10

import scala.collection.mutable.ArrayBuffer

object ClassDemo03 {
  def main(args: Array[String]): Unit = {
    val arr: ArrayBuffer[String] = ArrayBuffer("hadoop", "spark", "flink")
    println(s"arr:${arr}")
    arr += "flume"
    arr += "hadoop"
    println(s"arr:${arr}")
    arr -= "hadoop"
    arr -= "hadoop"
    println(s"arr:${arr}")
    arr ++= Array("hive", "sqoop")
    println(s"arr:${arr}")
    arr --= Array("sqoop", "spark")
    println(s"arr:${arr}")
  }

}
