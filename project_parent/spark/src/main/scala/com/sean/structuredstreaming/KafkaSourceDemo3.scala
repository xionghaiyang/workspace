package com.sean.structuredstreaming

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}

object KafkaSourceDemo3 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("KafkaSourceDemo")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    import spark.implicits._
    val lines: Dataset[String] = spark.read
      .format("kafka")
      .option("kafka.bootstrap.servers", "hadoop121:9092,hadoop122:9092,hadoop123:9092")
      .option("subscribe", "sparkafka")
      .option("startingOffsets", "earliest")
      .option("endingOffsets", "latest")
      .load()
      .select($"value")
      .as[String]

    val query: DataFrame = lines.flatMap(_.split(" "))
      .groupBy("value")
      .count()

    query.write
      .save("D://bigdata//data//text")

  }
}
