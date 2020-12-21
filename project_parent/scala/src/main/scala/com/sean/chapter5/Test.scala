package com.sean.chapter5

object Test {
  def getMax(a: Int, b: Int): Int = {
    if (a > b) a else b
  }

  def factorial(n: Int): Int = {
    if (n == 1) 1 else n * factorial(n - 1)
  }

  def getSum(a: Int, b: Int): Int = {
    println("getSum方法被执行了")
    a + b
  }

  def getSum1(x: Int = 10, y: Int = 20): Int = {
    x + y
  }

  def getSum2(a: Int*): Int = a.sum

  def sayHello() {
    println("Hello,Scala!")
  }

  val getSum111 = (x: Int, y: Int) => x + y

  def add(x: Int, y: Int): Int = x + y

  def printMT(n: Int) {
    for (i <- 1 to n; j <- 1 to i) {
      print(s"${j} * ${i} = ${j * i}\t")
      if (j == i) println()
    }
  }

  val printMT1 = (n: Int) => {
    for (i <- 1 to n; j <- 1 to i) {
      print(s"${j} * ${i} = ${j * i}\t")
      if (j == i) println()
    }
  }

  def main(args: Array[String]): Unit = {
    val max: Int = getMax(10, 20)
    println(s"max:${max}")

    val result = factorial(5)
    println(s"result:${result}")

    lazy val sum = getSum(1, 2)
    println(s"sum:${sum}")

    val sum1 = getSum1()
    println(s"sum1:${sum1}")

    val sum2 = getSum1(x = 1)
    println(s"sum2:${sum2}")

    val sum3 = getSum2(1, 2, 3, 4, 5)
    println(s"sum3:${sum3}")

    sayHello()

    println(getSum111(111, 222))

    val a = add _
    val result1 = a(1, 2)
    println(s"result1:${result1}")

    printMT(9)

    printMT1(5)

  }
}
