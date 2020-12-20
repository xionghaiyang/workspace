package com.sean.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TopN {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("TopN").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val file: RDD[String] = sc.textFile(ClassLoader.getSystemResource("access.log").getPath)
    val refUrlAndOne: RDD[(String, Int)] = file.map(_.split(" "))
      .filter(_.length > 10)
      .map(x => (x(10), 1))
      .filter(_._1.contains("http"))
    val result: RDD[(String, Int)] = refUrlAndOne.reduceByKey(_ + _)
      .sortBy(_._2, false)
    val finalResult: Array[(String, Int)] = result.take(5)
    println(finalResult.toBuffer)

    sc.stop()
  }

}
