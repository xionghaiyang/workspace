package com.sean.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("wordcount")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val dataRDD: RDD[String] = sc.textFile("file:///D://bigdata//Spark//itcast//data//wordcount.txt")
    println(dataRDD.collect().toBuffer)

    val wordCountRDD: RDD[(String, Int)] = dataRDD.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .sortBy(_._2, false)
    println(wordCountRDD.collect().toBuffer)

    sc.stop()
  }
}
