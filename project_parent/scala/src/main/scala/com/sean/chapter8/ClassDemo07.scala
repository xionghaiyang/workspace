package com.sean.chapter8

object ClassDemo07 {

  abstract class Template {
    def code()

    def getRuntime(): Long = {
      val start: Long = System.currentTimeMillis()
      code()
      val end: Long = System.currentTimeMillis()
      end - start
    }
  }

  class ForDemo extends Template{
    override def code(): Unit = for(i<-1 to 10000) println("Hello,Scala!")
  }

  def main(args: Array[String]): Unit = {
    println(new ForDemo().getRuntime())
  }

}
