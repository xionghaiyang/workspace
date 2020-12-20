package com.sean.sparkstreaming

import java.io.{BufferedReader, InputStreamReader}
import java.net.{ConnectException, Socket}
import java.nio.charset.StandardCharsets

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.internal.Logging
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.receiver.Receiver

class CustomReceiver(host: String, port: Int) extends Receiver[String](StorageLevel.MEMORY_AND_DISK_2) with Logging {
  override def onStart(): Unit = {
    new Thread("Socket Receiver") {
      override def run(): Unit = {
        receive()
      }
    }.start()
  }

  override def onStop(): Unit = ???

  private def receive(): Unit = {
    var socket: Socket = null
    var reader: BufferedReader = null
    var line: String = null
    try {
      socket = new Socket(host, port)
      reader = new BufferedReader(new InputStreamReader(socket.getInputStream, StandardCharsets.UTF_8))
      while (!isStopped && (line = reader.readLine()) != null) {
        store(line)
      }
      reader.close()
      socket.close()
      restart("Trying to connect again")
    } catch {
      case e: ConnectException =>
        restart(s"Error connecting to $host:$port", e)
      case t: Throwable =>
        restart("Error receiving data", t)
    }
  }
}

object CustomReceiver {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount") //.set("spark.driver.allowMultipleContexts","true")
    //val sc: SparkContext = new SparkContext(conf)
    //sc.setLogLevel("ERROR")
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(5))
    ssc.sparkContext.setLogLevel("ERROR")

    val lines: ReceiverInputDStream[String] = ssc.receiverStream(new CustomReceiver("hadoop121", 9999))
    val wordCounts: DStream[(String, Int)] = lines.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
    wordCounts.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
