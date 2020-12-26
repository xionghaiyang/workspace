package com.sean.chapter10

object ClassDemo11 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4)
    println(s"isEmpty:${list1.isEmpty}")
    val list2: List[Int] = List(4, 5, 6)
    val list3: List[Int] = list1 ++ list2
    println(s"list3:${list3}")
    println(s"head:${list3.head}")
    println(s"tail:${list3.tail}")
    val list4: List[Int] = list3.reverse
    println(s"list4:${list4}")
    println(s"take:${list3.take(3)}")
    println(s"drop:${list3.drop(3)}")
  }
}
