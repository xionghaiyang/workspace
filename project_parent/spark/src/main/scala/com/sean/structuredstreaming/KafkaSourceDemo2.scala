package com.sean.structuredstreaming

import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object KafkaSourceDemo2 {


  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("KafkaSourceDemo")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    val lines: Dataset[String] = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "hadoop121:9092,hadoop122:9092,hadoop123:9092")
      .option("subscribe", "sparkafka")
      .load()
      .select("value")
      .as[String]
    val query: DataFrame = lines.flatMap(_.split(" "))
      .groupBy("value")
      .count()
    query.writeStream
      .outputMode("complete")
      .format("console")
      .trigger(Trigger.ProcessingTime(1))
      //.option("checkpointLocation", "./ck1")
      .start()
      .awaitTermination()
  }
}
