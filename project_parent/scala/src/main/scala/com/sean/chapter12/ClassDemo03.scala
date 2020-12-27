package com.sean.chapter12

import scala.io.{BufferedSource, Source}

object ClassDemo03 {
  def main(args: Array[String]): Unit = {
    val source: BufferedSource = Source.fromFile("D://bigdata//data//2.txt")
    val strNumber: Array[String] = source.mkString.split("\\s+")
    val num: Array[Int] = strNumber.map(_.toInt)
    for (a <- num) println(a + 1)
  }
}
