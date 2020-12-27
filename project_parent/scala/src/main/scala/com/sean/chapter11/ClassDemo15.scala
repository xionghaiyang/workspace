package com.sean.chapter11

import scala.util.matching.Regex

object ClassDemo15 {
  def main(args: Array[String]): Unit = {
    val emList: List[String] = List("38123845@qq.com", "a1da88123f@gmail.com", "zhangsan@163.com", "123afadff.com")
    val regex: Regex = """.+@(.+)\..+""".r()
    val result: List[(String, String)] = emList.map {
      case email@regex(company) => email -> s"${company}"
      case email => email -> "未匹配"
    }
    println(result)
  }
}
