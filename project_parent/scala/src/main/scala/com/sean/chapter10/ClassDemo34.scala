package com.sean.chapter10

object ClassDemo34 {
  def main(args: Array[String]): Unit = {
    val stuList: List[(String, Int, Int, Int)] = List(("张三", 37, 90, 100), ("李四", 90, 73, 81), ("王五", 60, 90, 76), ("赵六", 59, 21, 72), ("田七", 100, 100, 100))
    val chineseList: List[(String, Int, Int, Int)] = stuList.filter(_._2 >= 60)
    val countList: List[(String, Int)] = stuList.map(x => x._1 -> (x._2 + x._3 + x._4))
    val sortList1: List[(String, Int)] = countList.sortBy(_._2).reverse
    val sortList2: List[(String, Int)] = countList.sortWith((x, y) => x._2 > y._2)
    println(s"语文成绩及格的学生信息:${chineseList}")
    println(s"所有学生及其总成绩:${countList}")
    println(s"总成绩降序排列:${sortList1}")
    println(s"总成绩降序排列:${sortList2}")
  }
}
