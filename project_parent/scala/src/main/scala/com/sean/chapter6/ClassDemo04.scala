package com.sean.chapter6

import java.text.SimpleDateFormat
import java.util.Date

object ClassDemo04 {

  class Person(var name: String = "", var age: Int = 0)

  object Person {
    def apply(name: String, age: Int): Person = new Person(name, age)
  }

  object DateUtils {
    var sdf: SimpleDateFormat = null

    def date2String(date: Date, template: String): String = {
      sdf = new SimpleDateFormat(template)
      sdf.format(date)
    }

    def string2Date(dateString: String, template: String): Date = {
      sdf = new SimpleDateFormat(template)
      sdf.parse(dateString)
    }

  }

  def main(args: Array[String]): Unit = {
    //val p: Person = new Person("张三", 23)
    val p: Person = Person("张三", 23)
    println(p.name, p.age)

    val s: String = DateUtils.date2String(new Date(),"yyyy-MM-dd")
    println(s"格式化日期:${s}")

    val d: Date = DateUtils.string2Date("13140521","yyyyMMdd")
    println(s"解析字符串:${d}")
  }
}
