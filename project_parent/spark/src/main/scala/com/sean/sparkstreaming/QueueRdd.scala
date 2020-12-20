package com.sean.sparkstreaming

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object QueueRdd {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("QueueRdd")
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(1))
    ssc.sparkContext.setLogLevel("ERROR")

    val rddQueue: mutable.SynchronizedQueue[RDD[Int]] = new mutable.SynchronizedQueue[RDD[Int]]()
    val inputStream: InputDStream[Int] = ssc.queueStream(rddQueue)
    val mapperdStream: DStream[(Int, Int)] = inputStream.map(x => (x % 10, 1))
    val reducedStream: DStream[(Int, Int)] = mapperdStream.reduceByKey(_ + _)

    reducedStream.print()

    ssc.start()

    for (i <- 1 to 30) {
      rddQueue += ssc.sparkContext.makeRDD(1 to 300, 10)
      Thread.sleep(2000)
      ssc.stop()
    }

  }
}
