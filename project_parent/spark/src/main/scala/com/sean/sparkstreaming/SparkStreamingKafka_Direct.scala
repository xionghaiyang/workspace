package com.sean.sparkstreaming

//import kafka.serializer.StringDecoder
//import org.apache.spark.streaming.dstream.{DStream, InputDStream}
//import org.apache.spark.streaming.kafka.KafkaUtils
//import org.apache.spark.streaming.{Seconds, StreamingContext}
//import org.apache.spark.{SparkConf, SparkContext}

object SparkStreamingKafka_Direct {
//  def main(args: Array[String]): Unit = {
//    val conf: SparkConf = new SparkConf().setAppName("SparkStreamingKafka_Direct").setMaster("local[2]")
//    val sc: SparkContext = new SparkContext(conf)
//    sc.setLogLevel("ERROR")
//    val ssc: StreamingContext = new StreamingContext(sc, Seconds(5))
//    ssc.checkpoint("./Kafka_Direct")
//
//    val kafkaParams: Map[String, String] = Map("metadata.broker.list" -> "hadoop121:9092,hadoop122:9092,hadoop123:9092", "group.id" -> "Kafka_Direct")
//    val topics: Set[String] = Set("sparkafka")
//    val dstream: InputDStream[(String, String)] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams, topics)
//    val result: DStream[(String, Int)] = dstream.map(_._2)
//      .flatMap(_.split(" "))
//      .map((_, 1))
//      .updateStateByKey((t1: Seq[Int], t2: Option[Int]) => {
//        val i: Int = t1.sum + t2.getOrElse(0)
//        Option(i)
//      })
//    result.print()
//    ssc.start()
//    ssc.awaitTermination()
//  }
}
