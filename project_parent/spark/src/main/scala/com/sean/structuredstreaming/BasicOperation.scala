package com.sean.structuredstreaming

import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.types.{LongType, StringType, StructType}

object BasicOperation {
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

    val df: Dataset[Row] = peopleDF.select("name","age","sex").where("age > 20")

    df.writeStream
      .outputMode("append")
      .format("console")
      .start()
      .awaitTermination()
  }
}
