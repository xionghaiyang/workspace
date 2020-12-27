package com.sean.chapter11

import scala.io.StdIn

object ClassDemo01 {
  def main(args: Array[String]): Unit = {
    println("请录入一个字符串:")
    val str: String = StdIn.readLine()
    val result: String = str match {
      case "hadoop" => "大数据分布式存储和计算框架"
      case "zookeeper" => "大数据分布式协调服务框架"
      case "spark" => "大数据分布式内存计算框架"
      case _ => "未匹配"
    }
    println(result)
    println("-" * 15)
    str match {
      case "hadoop" => println("大数据分布式存储和计算框架")
      case "zookeeper" => println("大数据分布式协调服务框架")
      case "spark" => println("大数据分布式内存计算框架")
      case _ => println("未匹配")
    }
  }
}
