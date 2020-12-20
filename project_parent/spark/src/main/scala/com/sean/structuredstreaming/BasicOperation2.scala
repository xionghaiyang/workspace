package com.sean.structuredstreaming

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.{LongType, StringType, StructType}

object BasicOperation2 {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[2]")
      .appName("BasicOperation")
      .getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val peopleSchema: StructType = new StructType()
      .add("name", StringType)
      .add("age", LongType)
      .add("sex", StringType)
    val peopleDF: DataFrame = spark.readStream
      .schema(peopleSchema)
      .json("D://bigdata//data//person")
    peopleDF.createOrReplaceTempView("people")
    val df: DataFrame = spark.sql("select * from people where age > 20")

    df.writeStream
      .outputMode("append")
      .format("console")
      .start()
      .awaitTermination()

  }
}
