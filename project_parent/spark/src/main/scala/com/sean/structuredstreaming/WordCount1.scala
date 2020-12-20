package com.sean.structuredstreaming

import org.apache.spark.sql.streaming.{StreamingQuery, Trigger}
import org.apache.spark.sql.{DataFrame, SparkSession}

object WordCount1 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[2]")
      .appName("WordCount1")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    val lines: DataFrame = spark.readStream
      .format("socket")
      .option("host", "hadoop121")
      .option("port", 9999)
      .load
    val wordCounts: DataFrame = lines.as[String]
      .flatMap(_.split(" "))
      .groupBy("value")
      .count()
    val query: StreamingQuery = wordCounts.writeStream
      .outputMode("complete")
      .trigger(Trigger.ProcessingTime(0))
      .format("console")
      .start()
    query.awaitTermination()
    spark.stop()
  }
}
