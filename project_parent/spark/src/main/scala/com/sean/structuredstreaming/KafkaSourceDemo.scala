package com.sean.structuredstreaming

import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.{DataFrame, SparkSession}

object KafkaSourceDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[2]")
      .appName("KafkaSourceDemo")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    //得到的 df 的 schema 是固定的: key,value,topic,partition,offset,timestamp,timestampType
    val df: DataFrame = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "hadoop121:9092,hadoop122:9092,hadoop123:9092")
      .option("subscribe","sparkafka")
      .load()

    df.writeStream
      .outputMode("update")
      .format("console")
      .trigger(Trigger.ProcessingTime(1))
      .start()
      .awaitTermination()
  }
}
