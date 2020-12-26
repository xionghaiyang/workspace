package com.sean.chapter9

object ClassDemo01 {
  def main(args: Array[String]): Unit = {
    val arr1: Array[Int] = new Array[Int](10)
    arr1(0) = 11
    println(arr1(0))
    println("-" * 15)
    val arr2: Array[String] = Array("java","scala","python")
    println(arr2.length)
  }
}
