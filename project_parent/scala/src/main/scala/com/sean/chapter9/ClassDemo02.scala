package com.sean.chapter9

import scala.collection.mutable.ArrayBuffer

object ClassDemo02 {
  def main(args: Array[String]): Unit = {
    val arr1: ArrayBuffer[Int] = new ArrayBuffer[Int]()
    println(s"arr1:$arr1")
    val arr2: ArrayBuffer[String] = ArrayBuffer("hadoop","storm","spark")
    println(s"arr2:$arr2")
  }
}
