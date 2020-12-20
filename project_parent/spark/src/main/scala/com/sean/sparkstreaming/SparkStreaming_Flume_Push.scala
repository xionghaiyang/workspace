package com.sean.sparkstreaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.flume.{FlumeUtils, SparkFlumeEvent}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming_Flume_Push {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("SparkStreaming_Flume_Push").setMaster("local[2]")
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(5))
    ssc.sparkContext.setLogLevel("ERROR")

    ssc.checkpoint("./")
    val flumeStream: ReceiverInputDStream[SparkFlumeEvent] = FlumeUtils.createStream(ssc, "192.168.128.123", 8888, StorageLevel.MEMORY_AND_DISK)
    val lineStream: DStream[String] = flumeStream.map(x => new String(x.event.getBody.array()))
    val result: DStream[(String, Int)] = lineStream.flatMap(_.split(" "))
      .map((_, 1))
      .updateStateByKey((newValues: Seq[Int], runningCount: Option[Int]) => {
        val newCount: Int = runningCount.getOrElse(0) + newValues.sum
        Some(newCount)
      })
    result.print()

    ssc.start()
    ssc.awaitTermination()
  }

}
