package com.sean.structuredstreaming

import org.apache.spark.sql.types.{LongType, StringType, StructType}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object BasicOperation1 {

  case class People(name: String, age: Long, sex: String)

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

    import spark.implicits._
    val peopleDS: Dataset[People] = peopleDF.as[People]

    val df: Dataset[String] = peopleDS.filter(_.age>20).map(_.name)

    df.writeStream
      .outputMode("append")
      .format("console")
      .start()
      .awaitTermination()
  }
}
