package com.sean.sparkcore

import java.sql.{Connection, DriverManager, PreparedStatement}

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object IpLocation {

  def ipToLong(ip: String): Long = {
    val split: Array[String] = ip.split("\\.")
    var returnNum: Long = 0L
    for (num <- split) {
      returnNum = num.toLong | returnNum << 8L
    }
    returnNum
  }

  def binarySearch(longIp: Long, value: Array[(Long, Long, String, String)]): Int = {
    var start: Int = 0
    var end: Int = value.length - 1
    var middle: Int = -1
    while (start <= end) {
      middle = (start + end) / 2
      if (longIp >= value(middle)._1 && longIp <= value(middle)._2) {
        return middle
      }
      if (longIp < value(middle)._1) {
        end = middle - 1
      }
      if (longIp > value(middle)._2) {
        start = middle + 1
      }
    }
    middle
  }

  def main(args: Array[String]): Unit = {
    val sc: SparkContext = new SparkContext(new SparkConf().setMaster("local[2]").setAppName("countIpHeat"))
    sc.setLogLevel("ERROR")

    val file: RDD[String] = sc.textFile(ClassLoader.getSystemResource("ip.txt").getPath)
    val ipRdd: RDD[(Long, Long, String, String)] = file.map(_.split("\\|"))
      .map(x => (x(0), x(1), x(x.length - 2), x(x.length - 1)))
      .map(x => (ipToLong(x._1), ipToLong(x._2), x._3, x._4))
    val broadcast: Broadcast[Array[(Long, Long, String, String)]] = sc.broadcast(ipRdd.collect)

    val file2: RDD[String] = sc.textFile(ClassLoader.getSystemResource("20090121000132.394251.http.format").getPath)
    println(file2.count)
    val userIpRdd: RDD[String] = file2.map(_.split("\\|")(1))
    val ipAndCount: RDD[((String, String), Int)] = userIpRdd.mapPartitions(iter => {
      val value: Array[(Long, Long, String, String)] = broadcast.value
      iter.map(ip => {
        val longIp: Long = ipToLong(ip)
        val resultIndex: Int = binarySearch(longIp, value)
        ((value(resultIndex)._3, value(resultIndex)._4), 1)
      })
    }).reduceByKey(_ + _)

    println(ipAndCount.count)
    val i: Int = ipAndCount.map(_._2).reduce(_ + _)
    println(i)

    ipAndCount.foreachPartition(iter => {
      Class.forName("com.mysql.jdbc.Driver").newInstance()
      val connection: Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spark", "root", "root")
      val preparedStatement: PreparedStatement = connection.prepareStatement("insert into iplocation(longitude,latitude,total_count) values(?,?,?)")
      iter.foreach(x => {
        preparedStatement.setString(1, x._1._1)
        preparedStatement.setString(2, x._1._2)
        preparedStatement.setInt(3, x._2)
        preparedStatement.execute()
      })
      try {
        if (preparedStatement != null) {
          preparedStatement.close()
        }
        if (connection != null) {
          connection.close()
        }
      } catch {
        case e: Exception => e.printStackTrace
      }
    })
    sc.stop()
  }

}
