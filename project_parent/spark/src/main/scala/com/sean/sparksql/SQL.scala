package com.sean.sparksql

import com.sean.sparksql.DataFrameTest.Person
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

object SQL {

  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().appName("sql").master("local[2]").getOrCreate()
    val sc: SparkContext = spark.sparkContext
    sc.setLogLevel("WARN")

    val lineRdd: RDD[Array[String]] = sc.textFile(ClassLoader.getSystemResource("person.txt").getPath).map(_.split(" "))
    val personRdd: RDD[Person] = lineRdd.map(x => Person(x(0).toInt, x(1), x(2).toInt))
    println(personRdd.collect.toBuffer)
    import spark.implicits._
    val personDF: DataFrame = personRdd.toDF
    personDF.show()

    //personDF.registerTempTable("t_person")
    personDF.createOrReplaceTempView("t_person")
    spark.sql("select * from t_person order by age desc limit 2").show
    spark.sql("desc t_person").show
    spark.sql("select * from t_person where age > 30").show

    spark.stop()
  }

}
