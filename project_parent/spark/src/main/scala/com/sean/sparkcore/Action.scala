package com.sean.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{Accumulator, SparkConf, SparkContext}

object Action {

  def rddShow(rdd: RDD[_]): Unit = {
    println(rdd.collect.toBuffer)
  }

  def reduce(sc: SparkContext): Unit = {
    val rdd1: RDD[Int] = sc.makeRDD(1 to 10, 2)
    rddShow(rdd1)
    val i: Int = rdd1.reduce(_ + _)
    println(i)
    val rdd2: RDD[(String, Int)] = sc.makeRDD(Array(("a", 1), ("a", 3), ("c", 3), ("d", 5)))
    rddShow(rdd2)
    val tuple: (String, Int) = rdd2.reduce((x, y) => (x._1 + y._1, x._2 + y._2))
    println(tuple)
  }

  def collect(sc: SparkContext): Unit = {
    val rdd1: RDD[Int] = sc.makeRDD(1 to 10, 2)
    println(rdd1.collect.toBuffer)
  }

  def count(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.makeRDD(1 to 10, 2)
    val l: Long = rdd.count()
    println(l)
  }

  def first(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.makeRDD(1 to 10, 2)
    val i: Int = rdd.first()
    println(i)
  }

  def take(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.makeRDD(1 to 10, 2)
    val ints: Array[Int] = rdd.take(5)
    println(ints.toBuffer)
  }

  def takeSample(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.parallelize(1 to 10, 2)
    rddShow(rdd)
    val ints: Array[Int] = rdd.takeSample(true, 5, 3)
    println(ints.toBuffer)
  }

  def takeOrdered(sc: SparkContext): Unit = {
    val rdd1: RDD[Int] = sc.makeRDD(Seq(10, 4, 2, 12, 3))
    rddShow(rdd1)
    val ints: Array[Int] = rdd1.top(2)
    println(ints.toBuffer)
    val ints1: Array[Int] = rdd1.takeOrdered(2)
    println(ints1.toBuffer)
  }

  def aggregate(sc: SparkContext): Unit = {
    val rdd1: RDD[Int] = sc.makeRDD(1 to 10, 2)
    val i: Int = rdd1.aggregate(1)(
      (x: Int, y: Int) => x + y,
      (a: Int, b: Int) => a + b
    )
    println(i)
  }

  def fold(sc: SparkContext): Unit = {
    val rdd1: RDD[Int] = sc.makeRDD(1 to 4, 2)
    rddShow(rdd1)
    val i: Int = rdd1.aggregate(1)(
      (x: Int, y: Int) => x + y,
      (a: Int, b: Int) => a + b
    )
    println(i)
    val i1: Int = rdd1.fold(1)(_ + _)
    println(i1)
  }

  def countByKey(sc: SparkContext): Unit = {
    val rdd: RDD[(Int, Int)] = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3), (3, 6), (3, 8)), 3)
    rddShow(rdd)
    val intToLong: collection.Map[Int, Long] = rdd.countByKey()
    println(intToLong)
  }

  def foreach(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.makeRDD(1 to 10, 2)
    val sum: Accumulator[Int] = sc.accumulator(0)
    rdd.foreach(sum += _)
    println(sum.value)
    rdd.collect.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("action").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")

    //reduce(sc)
    //collect(sc)
    //count(sc)
    //first(sc)
    //take(sc)
    //takeSample(sc)
    //takeOrdered(sc)
    //aggregate(sc)
    //fold(sc)
    //countByKey(sc)
    foreach(sc)

    sc.stop()
  }
}
