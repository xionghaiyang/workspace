package com.sean.chapter11

import scala.util.matching.Regex

object ClassDemo13 {
  def main(args: Array[String]): Unit = {
    val email: String = "qq12344@163.com"
    val regex: Regex = """.+@.+\..+""".r
    if (regex.findAllMatchIn(email).size != 0) {
      println(s"${email}是一个合法的邮箱")
    } else {
      println(s"${email}是一个非法的邮箱")
    }
  }
}
