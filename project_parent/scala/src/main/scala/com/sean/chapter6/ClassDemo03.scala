package com.sean.chapter6

object ClassDemo03 extends App {

  class Generals {
    def towar() = println(s"武将拿着${Generals.armsName}武器,上阵杀敌!")
  }

  object Generals {
    private var armsName = "青龙偃月刀"
  }

  //class Person(private[this] var name: String)
  class Person(private var name: String)

  object Person {
    def printPerson(p: Person) = println(p.name)
  }

  println("hello,scala")
  val g = new Generals
  g.towar()
  private val p: Person = new Person("张三")
  Person.printPerson(p)
}
