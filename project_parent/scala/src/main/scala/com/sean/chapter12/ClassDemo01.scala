package com.sean.chapter12

import scala.io.{BufferedSource, Source}

object ClassDemo01 {
  def main(args: Array[String]): Unit = {
    val source: BufferedSource = Source.fromFile("D://bigdata//data//1.txt")
    val lines: Iterator[String] = source.getLines()
    val list1: List[String] = lines.toList
    for (s <- list1) println(s)
    source.close()
  }
}
