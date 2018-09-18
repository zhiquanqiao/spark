package customsort

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by qiaozhiquan on 2018/9/18.
  */
object CustomSort5 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CustomSort1").setMaster("local[4]")
    val sc = new SparkContext(conf)

    //排序规则 首先按照颜值的从高到底排序 （降序），如果颜值相等，再按照年龄的从低到高排序（升序）
    val users = Array("laoduan 30 99", "laozhao 29 9999", "laozhang 38 99", "laoyang 90 99")

    //将Driver端数据并行化变成RDD
    val lines: RDD[String] = sc.parallelize(users, 3)
    //切分整理数据
    val tpRDD: RDD[(String, Int, Int)] = lines.map(line => {
      val fields = line.split(" ")
      val name = fields(0)
      val age = fields(1).toInt
      val fv = fields(2).toInt
      (name, age, fv)
    })

    //排序
    val sorted = tpRDD.sortBy(tp => (-tp._3, tp._2))
    val r = sorted.collect()
    println(r.toBuffer)
    sc.stop()
  }
}

