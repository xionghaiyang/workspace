package com.sean.sparkstreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.flume.{FlumeUtils, SparkFlumeEvent}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreamingPollFlume {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setAppName("SparkStreamingPollFlume").setMaster("local[2]")
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(5))
    ssc.sparkContext.setLogLevel("ERROR")
    ssc.checkpoint("./flume")

    val pollingStream: ReceiverInputDStream[SparkFlumeEvent] = FlumeUtils.createPollingStream(ssc, "192.168.128.123", 8888)
    val data: DStream[String] = pollingStream.map(x => new String(x.event.getBody.array()))

    val result: DStream[(String, Int)] = data.flatMap(_.split(" "))
      .map((_, 1))
      .updateStateByKey((currentValue: Seq[Int], historyValues: Option[Int]) => {
        val newValue: Int = currentValue.sum + historyValues.getOrElse(0)
        Some(newValue)
      })

    result.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
