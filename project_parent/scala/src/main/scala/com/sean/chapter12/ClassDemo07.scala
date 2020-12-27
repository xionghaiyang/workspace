package com.sean.chapter12

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

object ClassDemo07 {

  case class Person(var name: String, var age: Int)

  def main(args: Array[String]): Unit = {
//    val p: Person = Person("张三", 23)
//    val oos: ObjectOutputStream = new ObjectOutputStream(new FileOutputStream("D://bigdata//data//4.txt"))
//    oos.writeObject(p)
//    oos.close()

    val ois: ObjectInputStream = new ObjectInputStream(new FileInputStream("D://bigdata//data//4.txt"))
    val person: Person = ois.readObject().asInstanceOf[Person]
    println(person)
    ois.close()
  }
}
