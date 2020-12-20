package com.sean.sparkstreaming

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object QueueRdd {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("QueueRdd")
    //    val sc: SparkContext = new SparkContext(conf)
    //    sc.setLogLevel("ERROR")
    //val ssc: StreamingContext = new StreamingContext(sc, Seconds(5))
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(5))
    val sc: SparkContext = ssc.sparkContext
    sc.setLogLevel("ERROR")

    //val rddQueue: mutable.SynchronizedQueue[RDD[Int]] = new mutable.SynchronizedQueue[RDD[Int]]()
    val rddQueue: mutable.Queue[RDD[Int]] = mutable.Queue[RDD[Int]]()
    val inputStream: InputDStream[Int] = ssc.queueStream(rddQueue)
    //inputStream.reduce(_ + _).print()
    val mapperdStream: DStream[(Int, Int)] = inputStream.map(x => (x % 10, 1))
    val reducedStream: DStream[(Int, Int)] = mapperdStream.reduceByKey(_ + _)

    reducedStream.print()

    ssc.start()

    for (i <- 1 to 5) {
      rddQueue += sc.makeRDD(1 to 300)
      Thread.sleep(2000)
    }

    ssc.awaitTermination()
  }
}
