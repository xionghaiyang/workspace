package com.sean.chapter8

object ClassDemo04 {

  trait Hero {
    var name = ""
    var arms: String

    def eat() = println("吃肉喝酒，养精蓄锐！")

    def towar(): Unit
  }

  class Generals extends Hero {
    override var arms: String = ""

    override def towar(): Unit = println(s"${name}带着${arms},上阵杀敌!")
  }

  def main(args: Array[String]): Unit = {
    val gy: Generals = new Generals
    gy.name = "关羽"
    gy.arms = "青龙偃月刀"
    println(gy.name, gy.arms)
    gy.eat()
    gy.towar()
  }

}
