package com.sean.chapter10

object ClassDemo18 {
  def main(args: Array[String]): Unit = {
    import scala.collection.mutable.Set
    val set1: Set[Int] = Set(1, 2, 3, 4)
    println(set1)
    set1 += 5
    println(set1)
    set1 ++= Set(6, 7, 8)
    //set1 ++= List(6, 7, 8)
    println(set1)
    set1 -= 1
    println(set1)
    set1 --= List(3, 5, 7)
    println(set1)
  }
}
