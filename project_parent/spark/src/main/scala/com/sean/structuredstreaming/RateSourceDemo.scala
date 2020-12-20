package com.sean.structuredstreaming

import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.{DataFrame, SparkSession}

object RateSourceDemo {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[2]")
      .appName("RateSourceDemo")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val rows: DataFrame = spark.readStream
      .format("rate")
      .option("rowsPerSecond", 10)
      .option("rampUpTime", 1)
      .option("numPartitions", 2)
      .load()

    rows.writeStream
      .outputMode("append")
      .trigger(Trigger.ProcessingTime(1))
      .start()
      .awaitTermination()
  }
}
