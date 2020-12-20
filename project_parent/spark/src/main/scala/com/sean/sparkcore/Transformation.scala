package com.sean.sparkcore

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object Transformation {

  def rddShow(rdd: RDD[_]): Unit = {
    println(rdd.collect.toBuffer)
  }

  def map(sc: SparkContext): Unit = {
    val source: RDD[Int] = sc.parallelize(1 to 10)
    rddShow(source)
    val mapadd: RDD[Int] = source.map(_ * 2)
    rddShow(mapadd)
  }

  def filter(sc: SparkContext): Unit = {
    val sourceFilter: RDD[String] = sc.parallelize(Array("xiaoming", "xiaojiang", "xiaohe", "dazhi"))
    rddShow(sourceFilter)
    val filter: RDD[String] = sourceFilter.filter(_.contains("xiao"))
    rddShow(filter)
  }

  def flatMap(sc: SparkContext): Unit = {
    val sourceFlat: RDD[Int] = sc.parallelize(1 to 5)
    rddShow(sourceFlat)
    val flatMap: RDD[Int] = sourceFlat.flatMap(1 to _)
    rddShow(flatMap)
  }

  def mapPartitions(sc: SparkContext): Unit = {
    val rdd: RDD[(String, String)] = sc.parallelize(List(("kpop", "female"), ("zorro", "male"), ("mobin", "male"), ("lucy", "female")))
    rddShow(rdd)
    val result: RDD[String] = rdd.mapPartitions(iter => {
      var woman: List[String] = List[String]()
      while (iter.hasNext) {
        val next: (String, String) = iter.next()
        next match {
          case (_, "female") => woman = next._1 :: woman
          case _ =>
        }
      }
      woman.iterator
    })
    rddShow(rdd)
  }

  def mapPartitionsWithIndex(sc: SparkContext): Unit = {
    val rdd: RDD[(String, String)] = sc.parallelize(List(("kpop", "female"), ("zorro", "male"), ("mobin", "male"), ("lucy", "female")))
    rddShow(rdd)
    val result: RDD[String] = rdd.mapPartitionsWithIndex((index, iter) => {
      var woman: List[String] = List[String]()
      while (iter.hasNext) {
        val next: (String, String) = iter.next()
        next match {
          case (_, "female") => woman = "[" + index + "]" + next._1 :: woman
          case _ =>
        }
      }
      woman.iterator
    })
    rddShow(result)
  }

  def sample(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.parallelize(1 to 10)
    rddShow(rdd)
    val sample1: RDD[Int] = rdd.sample(true, 0.4, 2)
    rddShow(sample1)
    val sample2: RDD[Int] = rdd.sample(false, 0.2, 3)
    rddShow(sample2)
  }

  def takeSample(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.parallelize(1 to 10)
    rddShow(rdd)
    val sample1: Array[Int] = rdd.takeSample(true, 10, 1)
    println(sample1.toBuffer)
    val sample2: Array[Int] = rdd.takeSample(false, 10, 1)
    println(sample2.toBuffer)
  }

  def union(sc: SparkContext): Unit = {
    val rdd1: RDD[Int] = sc.parallelize(1 to 5)
    rddShow(rdd1)
    val rdd2: RDD[Int] = sc.parallelize(5 to 10)
    rddShow(rdd2)
    val rdd3: RDD[Int] = rdd1.union(rdd2)
    rddShow(rdd3)
  }

  def intersection(sc: SparkContext): Unit = {
    val rdd1: RDD[Int] = sc.parallelize(1 to 7)
    rddShow(rdd1)
    val rdd2: RDD[Int] = sc.parallelize(5 to 10)
    rddShow(rdd2)
    val rdd3: RDD[Int] = rdd1.intersection(rdd2)
    rddShow(rdd3)
  }

  def distinct(sc: SparkContext): Unit = {
    val distinctRdd: RDD[Int] = sc.parallelize(List(1, 2, 1, 5, 2, 9, 6, 1))
    rddShow(distinctRdd)
    val unionRDD1: RDD[Int] = distinctRdd.distinct()
    rddShow(unionRDD1)
    val unionRDD2: RDD[Int] = distinctRdd.distinct(2)
    rddShow(unionRDD2)
  }

  def partitionBy(sc: SparkContext): Unit = {
    val rdd: RDD[(Int, String)] = sc.parallelize(Array((1, "aaa"), (2, "bbb"), (3, "ccc"), (4, "ddd")), 4)
    rddShow(rdd)
    println(rdd.partitions.size)
    val rdd2: RDD[(Int, String)] = rdd.partitionBy(new HashPartitioner(2))
    rddShow(rdd2)
    println(rdd2.partitions.size)
  }

  def reduceByKey(sc: SparkContext): Unit = {
    val rdd: RDD[(String, Int)] = sc.parallelize(List(("female", 1), ("male", 5), ("female", 5), ("male", 2)))
    rddShow(rdd)
    val reduce: RDD[(String, Int)] = rdd.reduceByKey(_ + _)
    rddShow(reduce)
  }

  def groupByKey(sc: SparkContext): Unit = {
    val wordPairsRDD: RDD[(String, Int)] = sc.parallelize(Array("one", "two", "two", "three", "three", "three"))
      .map(word => (word, 1))
    rddShow(wordPairsRDD)
    val group: RDD[(String, Iterable[Int])] = wordPairsRDD.groupByKey()
    rddShow(group)
    val wordcount: RDD[(String, Int)] = group.map(t => (t._1, t._2.sum))
    rddShow(wordcount)
  }

  def combineByKey(sc: SparkContext): Unit = {
    val scores: Array[(String, Int)] = Array(("Fred", 88), ("Fred", 95), ("Fred", 91), ("Wilma", 93), ("Wilma", 95), ("Wilma", 98))
    val input: RDD[(String, Int)] = sc.parallelize(scores)
    rddShow(input)
    val combine: RDD[(String, (Int, Int))] = input.combineByKey(
      v => (v, 1),
      (acc1: (Int, Int), acc2: Int) => (acc1._1 + acc2, acc1._2 + 1),
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc2._2 + acc2._2)
    )
    rddShow(combine)
    val result: RDD[(String, Double)] = combine.map { case (k, v) => (k, v._1.toDouble / v._2) }
    rddShow(result)
  }

  def aggregateByKey(sc: SparkContext): Unit = {
    val rdd: RDD[(Int, Int)] = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3), (3, 6), (3, 8)), 3)
    rddShow(rdd)
    val agg: RDD[(Int, Int)] = rdd.aggregateByKey(0)(math.max(_, _), _ + _)
    rddShow(agg)
    println(agg.partitions.size)
    val rdd1: RDD[(Int, Int)] = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3), (3, 6), (3, 8)), 1)
    rddShow(rdd1)
    val agg1: RDD[(Int, Int)] = rdd1.aggregateByKey(0)(math.max(_, _), _ + _)
    rddShow(agg1)
    println(agg1.partitions.size)
  }

  def foldByKey(sc: SparkContext): Unit = {
    val rdd: RDD[(Int, Int)] = sc.parallelize(List((1, 3), (1, 2), (1, 4), (2, 3), (3, 6), (3, 8)), 3)
    rddShow(rdd)
    val agg: RDD[(Int, Int)] = rdd.foldByKey(0)(_ + _)
    rddShow(agg)
  }

  def sortByKey(sc: SparkContext): Unit = {
    val rdd: RDD[(Int, String)] = sc.parallelize(Array((3, "aa"), (6, "cc"), (2, "bb"), (1, "dd")))
    rddShow(rdd)
    val result1: RDD[(Int, String)] = rdd.sortByKey(false)
    rddShow(result1)
    val result2: RDD[(Int, String)] = rdd.sortByKey(true)
    rddShow(result2)
  }

  def sortBy(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.parallelize(List(1, 2, 3, 4))
    rddShow(rdd)
    val result1: RDD[Int] = rdd.sortBy(x => x)
    rddShow(result1)
    val result2: RDD[Int] = rdd.sortBy(x => x % 3)
    rddShow(result2)
  }

  def join(sc: SparkContext): Unit = {
    val rdd: RDD[(Int, String)] = sc.parallelize(Array((1, "a"), (2, "b"), (3, "c")))
    rddShow(rdd)
    val rdd1: RDD[(Int, Int)] = sc.parallelize(Array((1, 4), (2, 5), (3, 6)))
    rddShow(rdd1)
    val result: RDD[(Int, (String, Int))] = rdd.join(rdd1).sortByKey()
    rddShow(result)
  }

  def cogroup(sc: SparkContext): Unit = {
    val rdd: RDD[(Int, String)] = sc.parallelize(Array((1, "a"), (2, "b"), (3, "c")))
    rddShow(rdd)
    val rdd1: RDD[(Int, Int)] = sc.parallelize(Array((1, 4), (2, 5), (3, 6)))
    rddShow(rdd1)
    val result1: RDD[(Int, (Iterable[String], Iterable[Int]))] = rdd.cogroup(rdd1).sortByKey()
    rddShow(result1)
    val rdd2: RDD[(Int, Int)] = sc.parallelize(Array((4, 4), (2, 5), (3, 6)))
    rddShow(rdd2)
    val result2: RDD[(Int, (Iterable[String], Iterable[Int]))] = rdd.cogroup(rdd2).sortByKey()
    rddShow(result2)
    val rdd3: RDD[(Int, String)] = sc.parallelize(Array((1, "a"), (1, "d"), (2, "b"), (3, "c")))
    rddShow(rdd3)
    val result3: RDD[(Int, (Iterable[String], Iterable[String]))] = rdd.cogroup(rdd3).sortByKey()
    rddShow(result3)
  }

  def cartesian(sc: SparkContext): Unit = {
    val rdd1: RDD[Int] = sc.parallelize(1 to 3)
    rddShow(rdd1)
    val rdd2: RDD[Int] = sc.parallelize(2 to 5)
    rddShow(rdd2)
    val result: RDD[(Int, Int)] = rdd1.cartesian(rdd2).sortByKey()
    rddShow(result)
  }

  def coalesce(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.parallelize(1 to 16, 4)
    rddShow(rdd)
    println(rdd.partitions.size)
    val rdd1: RDD[Int] = rdd.coalesce(3)
    rddShow(rdd1)
    println(rdd1.partitions.size)
  }

  def repartition(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.parallelize(1 to 16, 4)
    rddShow(rdd)
    println(rdd.partitions.size)
    val rdd1: RDD[Int] = rdd.repartition(3)
    rddShow(rdd1)
    println(rdd1.partitions.size)
  }

  def glom(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.parallelize(1 to 16, 4)
    rddShow(rdd)
    val rdd1: RDD[Array[Int]] = rdd.glom()
    rdd1.map(_.toBuffer).foreach(println)
  }

  def mapValues(sc: SparkContext): Unit = {
    val rdd1: RDD[(Int, String)] = sc.parallelize(Array((1,"a"),(1,"d"),(2,"b"),(3,"c")))
    rddShow(rdd1)
    val rdd2: RDD[(Int, String)] = rdd1.mapValues(_+"|||")
    rddShow(rdd2)
  }

  def subtract(sc: SparkContext): Unit = {
    val rdd: RDD[Int] = sc.parallelize(3 to 8)
    rddShow(rdd)
    val rdd1: RDD[Int] = sc.parallelize(1 to 5)
    rddShow(rdd1)
    val result: RDD[Int] = rdd.subtract(rdd1)
    rddShow(result)
  }

  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("transformation")
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")

    //map(sc)
    //filter(sc)
    //flatMap(sc)
    //mapPartitions(sc)
    //mapPartitionsWithIndex(sc)
    //sample(sc)
    //takeSample(sc)
    //union(sc)
    //intersection(sc)
    //distinct(sc)
    //partitionBy(sc)
    //reduceByKey(sc)
    //groupByKey(sc)
    //combineByKey(sc)
    //aggregateByKey(sc)
    //foldByKey(sc)
    //sortByKey(sc)
    //sortBy(sc)
    //join(sc)
    //cogroup(sc)
    //cartesian(sc)
    //coalesce(sc)
    //repartition(sc)
    //glom(sc)
    //mapValues(sc)
    subtract(sc)

    sc.stop()
  }

}
