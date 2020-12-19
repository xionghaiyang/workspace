package com.sean.sparksql

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

object DataFrameTest {

  case class Person(id: Int, name: String, age: Int)

  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().appName("dataframetest1").master("local[2]").getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("ERROR")

    val lineRdd: RDD[Array[String]] = sc.textFile(ClassLoader.getSystemResource("person.txt").getPath).map(_.split(" "))
    val personRdd: RDD[Person] = lineRdd.map(x => Person(x(0).toInt, x(1), x(2).toInt))
    println(personRdd.collect.toBuffer)
    import spark.implicits._
    val personDF: DataFrame = personRdd.toDF
    personDF.show()

    spark.stop()
  }
}
