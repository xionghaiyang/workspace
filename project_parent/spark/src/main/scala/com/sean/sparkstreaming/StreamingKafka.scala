package com.sean.sparkstreaming

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka010.{CanCommitOffsets, ConsumerStrategies, HasOffsetRanges, KafkaUtils, LocationStrategies, OffsetRange}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext, TaskContext}

object StreamingKafka {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[4]").setAppName("StreamingKafka")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val ssc: StreamingContext = new StreamingContext(sc, Seconds(1))

    val brokers: String = "hadoop121:9092,hadoop122:9092,hadoop123:9092"
    val sourcetopic: String = "sparkafka"
    val group: String = "sparkafkaGroup"
    val reset: String = "latest"
    val topics: Array[String] = Array(sourcetopic)
    val kafkaParams: collection.Map[String, Object] = Map(
      "bootstrap.servers" -> brokers,
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> group,
      "auto.offset.reset" -> reset,
      "enable.auto.commit" -> (false:java.lang.Boolean)
    )
    val stream: InputDStream[ConsumerRecord[String, String]] = KafkaUtils.createDirectStream[String, String](ssc, LocationStrategies.PreferConsistent, ConsumerStrategies.Subscribe[String, String](topics, kafkaParams))
    stream.foreachRDD(rdd => {
      if (rdd.count() > 0) {
        println("接收kafka当中的数据")
        rdd.foreach(f => {
          val kafkaValue: String = f.value()
          println(kafkaValue)
        })
        val offsetRanges: Array[OffsetRange] = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
        rdd.foreachPartition(iter => {
          val o: OffsetRange = offsetRanges(TaskContext.get.partitionId())
          println(s"${o.topic} ${o.partition} ${o.fromOffset} ${o.untilOffset}")
        })
        println("=================================================")
        stream.asInstanceOf[CanCommitOffsets].commitAsync(offsetRanges)
      }
    })

    ssc.start()
    ssc.awaitTermination()

  }
}
