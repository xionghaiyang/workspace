package com.sean.chapter12

import java.io.FileOutputStream

object ClassDemo06 {
  def main(args: Array[String]): Unit = {
    val pw: FileOutputStream = new FileOutputStream("D://bigdata//data//3.txt")
    pw.write("好好学习，\r\n".getBytes())
    pw.write("天天向上！\r\n".getBytes())
    pw.close()
  }
}
