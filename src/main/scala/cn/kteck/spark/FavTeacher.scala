package cn.kteck.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by qiaozhiquan on 2018/9/17.
  */
object FavTeacher {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("FavTeacher").setMaster("local[4]")
    val sc = new SparkContext(conf)
    //指定从哪里读取数据

    val file = "G:\\小牛学堂\\06-Spark安装部署到高级-10天\\spark-03-TopN与WordCount执行过程详解\\课件与代码\\teacher.log"
    val lines = sc.textFile(file)
    //整理数据 学科 老师
    val teacherAndOne = lines.map(line => {
      val splits = line.split("/")
      //      val subject = splits(2).substring(0,splits(2).indexOf("."))
      val teacher = splits(3)
      (teacher, 1)
    })

    //聚合
    val reduced:RDD[(String,Int)] = teacherAndOne.reduceByKey(_+_)
    //排序
    val sorted:RDD[(String,Int)] = reduced.sortBy(_._2,false)
    //触发Action
    val result = sorted.collect
    println(result.toBuffer)

  }
}
