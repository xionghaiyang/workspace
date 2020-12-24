package com.sean.chapter8

object ClassDemo11 {

  abstract class Programmer {
    var name = ""
    var age = 0

    def eat()

    def skill()
  }

  trait BigData {
    def learningBigData() = {
      println("来到黑马程序员之后：")
      println("我学会了: Hadoop, Zookeeper, HBase, Hive, Sqoop, Scala, Spark, Flink等技术")
      println("我学会了: 企业级360°全方位用户画像, 千亿级数据仓, 黑马推荐系统, 电信信号强度诊断等项目")
    }
  }

  class JavaProgrammer extends Programmer {
    override def eat(): Unit = println("Java程序员吃大白菜, 喝大米粥.")

    override def skill(): Unit = println("我精通Java技术.")
  }

  class PythonProgrammer extends Programmer {
    override def eat(): Unit = println("Python程序员吃小白菜, 喝小米粥.")

    override def skill(): Unit = println("我精通Python技术.")
  }

  class PartJavaProgramme extends JavaProgrammer with BigData {
    override def eat(): Unit = println("精通Java和大数据的程序员, 吃牛肉, 喝牛奶")

    override def skill(): Unit = {
      super.skill()
      learningBigData()
    }
  }

  class PartPythonProgrammer extends PythonProgrammer with BigData {
    override def eat(): Unit = println("精通Python和大数据的程序员, 吃羊肉, 喝羊奶")

    override def skill(): Unit = {
      super.skill()
      learningBigData()
    }
  }

  def main(args: Array[String]): Unit = {

    val jp: JavaProgrammer = new JavaProgrammer
    jp.name = "张三"
    jp.age = 23
    println(s"我叫${jp.name},年龄为${jp.age},我是普通的Java程序员")
    jp.eat()
    jp.skill()
    println("-" * 15)

    val pjp: PartJavaProgramme = new PartJavaProgramme
    pjp.name="李四"
    pjp.age=24
    println(s"我叫${pjp.name},年龄为${pjp.age},我精通Java技术和大数据技术")
    pjp.eat()
    pjp.skill()


  }
}
