package com.sean.chapter4

import scala.collection.immutable

object Test1 {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10 if i % 3 == 0) println(i)
    val v: immutable.IndexedSeq[Int] = for (i <- 1 to 10) yield i * 10
    println(v)

    import scala.util.control.Breaks._
    breakable {
      for (i <- 1 to 10) {
        if (i == 5) break() else println(i)
      }
    }

    for (i <- 1 to 4) {
      breakable {
        if (i % 3 == 0) break() else println(i)
      }
    }

    for (i <- 1 to 9; j <- 1 to i) {
      print(s"${j} * ${i} = ${i * j}\t")
      if (j == i) println()
    }
  }
}
