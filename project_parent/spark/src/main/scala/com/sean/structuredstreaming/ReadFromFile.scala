package com.sean.structuredstreaming

import org.apache.spark.sql.streaming.{StreamingQuery, Trigger}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.{LongType, StringType, StructType}

object ReadFromFile {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[2]")
      .appName("ReadFromFile")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val userSchema: StructType = new StructType().add("name", StringType)
      .add("age", LongType)
      .add("adress", StringType)
    val user: DataFrame = spark.readStream
      .format("csv")
      .schema(userSchema)
      .load("D://bigdata//data")
    val query: StreamingQuery = user.writeStream
      .outputMode("append")
      .trigger(Trigger.ProcessingTime(0))
      .format("console")
      .start()
    query.awaitTermination()
  }
}
