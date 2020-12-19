package com.sean.sparksql

import com.sean.sparksql.DataFrameTest.Person
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

object DSL {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[2]").appName("dsl").getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")

    val lineRdd: RDD[Array[String]] = sc.textFile(ClassLoader.getSystemResource("person.txt").getPath).map(_.split(" "))
    val personRdd: RDD[Person] = lineRdd.map(x => Person(x(0).toInt, x(1), x(2).toInt))
    println(personRdd.collect.toBuffer)
    import spark.implicits._
    val personDF: DataFrame = personRdd.toDF
    personDF.show()

    personDF.select($"name").show
    personDF.select($"name", $"age").show
    personDF.printSchema()
    personDF.select($"id", $"age" + 1).show
    personDF.filter($"age" >= 25).show
    println(personDF.filter($"age" > 30).count)

    personDF.groupBy("age").count().show()


    spark.stop()
  }

}
