package com.sean.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object UV {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("UV").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val file: RDD[String] = sc.textFile(ClassLoader.getSystemResource("access.log").getPath)
    val totalUV: RDD[String] = file.map(_.split(" ")(0))
        .distinct(1)
    println(totalUV.count())

    sc.stop()
  }
}
