package com.sean.sparkstreaming

import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object StreamingFile {

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("StreamingFile").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val ssc: StreamingContext = new StreamingContext(sc, Seconds(5))

    ssc.checkpoint("./hdfs-data")
//    val value: RDD[String] = sc.textFile("hdfs://hadoop121:8020/stream-data/wordcount.txt")
//    println(value.collect.toBuffer)
    val fileStream: DStream[String] = ssc.textFileStream("hdfs://hadoop121:8020/stream-data/")
    fileStream.print()
    val words: DStream[String] = fileStream.flatMap(x => x.split(" "))
    val wordAndOne: DStream[(String, Int)] = words.map((_, 1))

    val result: DStream[(String, Int)] = wordAndOne.updateStateByKey((newValues: Seq[Int], runnintCount: Option[Int]) => {
      val finalResult: Int = runnintCount.getOrElse(0) + newValues.sum
      Option(finalResult)
    })
    result.print()

    ssc.start()
    ssc.awaitTermination()
  }

}
