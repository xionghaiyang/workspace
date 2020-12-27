package com.sean.chapter12

import java.io.{BufferedWriter, FileWriter}

import scala.collection.mutable.ListBuffer
import scala.io.{BufferedSource, Source}

object ClassDemo08 {

  case class Student(name: String, chinese: Int, math: Int, english: Int) {
    def getSum(): Int = chinese + math + english
  }

  def main(args: Array[String]): Unit = {
    val source: BufferedSource = Source.fromFile("D://bigdata//data//student.txt")
    val studentList: Iterator[List[String]] = source.getLines()
      .map(_.split(" "))
      .map(_.toList)
    val list: ListBuffer[Student] = new ListBuffer[Student]()
    for (s <- studentList) {
      list += Student(s(0), s(1).toInt, s(2).toInt, s(3).toInt)
    }
    val sortList: List[Student] = list.sortBy(_.getSum())
      .reverse
      .toList
    val bw: BufferedWriter = new BufferedWriter(new FileWriter("D://bigdata//data//stu.txt"))
    for (s <- sortList) bw.write(s"${s.name} ${s.chinese} ${s.math} ${s.english} ${s.getSum()}\r\n")
    bw.close()
  }
}
