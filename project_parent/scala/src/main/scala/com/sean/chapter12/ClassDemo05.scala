package com.sean.chapter12

import java.io.{File, FileInputStream}

object ClassDemo05 {
  def main(args: Array[String]): Unit = {
    val file: File = new File("D://bigdata//data//1.txt")
    val fis: FileInputStream = new FileInputStream(file)
    val bys: Array[Byte] = new Array[Byte](file.length().toInt)
    fis.read(bys)
    fis.close()
    println(bys.length)
  }
}
