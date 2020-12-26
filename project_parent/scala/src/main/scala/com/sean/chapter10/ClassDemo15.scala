package com.sean.chapter10

object ClassDemo15 {
  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4)
    val list2: List[Int] = List(3, 4, 5, 6)
    val unionList: List[Int] = list1.union(list2)
    val distinctList: List[Int] = unionList.distinct
    val intersectList: List[Int] = list1.intersect(list2)
    val diffList: List[Int] = list1.diff(list2)
    println(s"并集,不去重:${unionList}")
    println(s"并集,去重:${distinctList}")
    println(s"交集:${intersectList}")
    println(s"差集:${diffList}")
  }
}
