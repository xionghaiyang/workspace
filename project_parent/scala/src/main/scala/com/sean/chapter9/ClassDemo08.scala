package com.sean.chapter9

object ClassDemo08 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4)
    val list2: Nil.type = Nil
    val list3: List[Int] = -2 :: -1 :: Nil
    println(s"list1:${list1}")
    println(s"list2:${list2}")
    println(s"list3:${list3}")
  }
}
