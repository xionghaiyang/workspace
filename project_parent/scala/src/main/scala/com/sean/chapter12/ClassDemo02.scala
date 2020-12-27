package com.sean.chapter12

import scala.io.{BufferedSource, Source}


object ClassDemo02 {
  def main(args: Array[String]): Unit = {
    val source: BufferedSource = Source.fromFile("D://bigdata//data//1.txt")
    val iter: BufferedIterator[Char] = source.buffered
    while (iter.hasNext) {
      print(iter.next())
    }
    val str: String = source.mkString
    println(str)
    source.close()
  }
}
