package com.sean.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object PV {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("PV").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val file: RDD[String] = sc.textFile(ClassLoader.getSystemResource("access.log").getPath)
//    val totalPv: RDD[(String, Int)] = file.map(_ => ("pv", 1)).reduceByKey(_ + _)
//    totalPv.foreach(println)
    println(file.count)

    sc.stop()
  }
}
