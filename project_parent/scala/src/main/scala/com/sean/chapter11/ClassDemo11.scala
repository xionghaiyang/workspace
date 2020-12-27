package com.sean.chapter11

object ClassDemo11 {
  def main(args: Array[String]): Unit = {
    val pf: PartialFunction[Int, String] = {
      case 1 => "一"
      case 2 => "二"
      case 3 => "三"
      case _ => "其他"
    }
    println(pf(1))
    println(pf(1))
    println(pf(1))
    println(pf(1))
  }
}
