package com.sean.chapter8

object ClassDemo06 {

  trait PlayLOL {
    def top()

    def mid()

    def adc()

    def support()

    def jungle()

    def schoolchild()
  }

  class Player extends PlayLOL {
    override def top(): Unit = {}

    override def mid(): Unit = {}

    override def adc(): Unit = {}

    override def support(): Unit = {}

    override def jungle(): Unit = {}

    override def schoolchild(): Unit = {}
  }

  class GreenHand extends Player{
    override def support(): Unit = println("我是辅助，B键一扣，不死不回城!")

    override def schoolchild(): Unit = println("我是小学生，你骂我，我就挂机!")
  }

  def main(args: Array[String]): Unit = {
    val gh: GreenHand = new GreenHand
    gh.support()
    gh.schoolchild()
  }
}
