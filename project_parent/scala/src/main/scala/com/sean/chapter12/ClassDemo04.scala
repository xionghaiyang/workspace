package com.sean.chapter12

import java.net.URI

import scala.io.{BufferedSource, Source}

object ClassDemo04 {
  def main(args: Array[String]): Unit = {
    val source: BufferedSource = Source.fromURI(new URI("http://www.itcast.cn"))
    println(source.mkString)
    val str: Source = Source.fromString("黑马程序员")
    println(str.getLines())
  }
}
