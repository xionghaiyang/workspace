package com.sean.sparkstreaming

//import org.apache.spark.storage.StorageLevel
//import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
//import org.apache.spark.streaming.kafka.KafkaUtils
//import org.apache.spark.streaming.{Seconds, StreamingContext}
//import org.apache.spark.{SparkConf, SparkContext}
//
//import scala.collection.immutable

object StreamKafkaReceiver {
  /**
    * #关闭安全模式
    * hadoop dfsadmin -safemode leave
    */
//  def main(args: Array[String]): Unit = {
//    val conf: SparkConf = new SparkConf().setAppName("StreamKafkaReceiver").setMaster("local[8]")
//    val sc: SparkContext = new SparkContext(conf)
//    sc.setLogLevel("ERROR")
//    val ssc: StreamingContext = new StreamingContext(sc, Seconds(5))
//
//    ssc.checkpoint("./Kafka_Receiver")
//    val zkQuorum: String = "hadoop121:2181,hadoop122:2181,hadoop123:2181"
//    val groupId: String = "sparkafka_group"
//    val topics: Map[String, Int] = Map("sparkafka" -> 3)
//    val receiverDstream: immutable.IndexedSeq[ReceiverInputDStream[(String, String)]] = (1 to 3).map(x => {
//      val stream: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream(ssc, zkQuorum, groupId, topics, StorageLevel.MEMORY_ONLY)
//      stream
//    })
//    val unionDStream: DStream[(String, String)] = ssc.union(receiverDstream)
//    val result: DStream[(String, Int)] = unionDStream.map(_._2)
//      .flatMap(_.split(" "))
//      .map((_, 1))
//      .reduceByKey(_ + _)
//    result.print()
//
//    ssc.start()
//    ssc.awaitTermination()
//  }
}
