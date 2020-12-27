package com.sean.chapter11

import scala.util.matching.Regex

object ClassDemo14 {
  def main(args: Array[String]): Unit = {
    val emList: List[String] = List("38123825@qqcom", "a1da88123@gmail.com", "zhangsan@163.com", "123dfadff.com")
    val regex: Regex = """.+@.+\..+""".r()
    val list: List[String] = emList.filter(x => regex.findAllMatchIn(x).size == 0)
    println(list)
  }
}
