package cn.kteck.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by qiaozhiquan on 2018/09/10
  */
object ScalaWordCount{

  def main(args: Array[String]): Unit = {
    //创建spark 配置,设置应用程序名字
//    var conf = new SparkConf().setAppName("wordCount")
    var conf = new SparkConf().setAppName("wordCount").setMaster("local[*]")  //单机调试
    //创建spark入口
    val sc = new SparkContext()
    //指定以后从哪里读取数据 RDD（弹性分布式数据集）
    val lines:RDD[String] = sc.textFile(args(0))
    //切分压平
    val words:RDD[String] = lines.flatMap(_.split(" "))
    val wordAndOne:RDD[(String,Int)] = words.map((_,1))
    //按照可以进行聚合
    val reduced:RDD[(String,Int)] = wordAndOne.reduceByKey(_+_)
    val sorted:RDD[(String,Int)] = reduced.sortBy(_._1,false)
    lines.count()
    sorted.saveAsTextFile(args(1))
    //释放资源
    sc.stop()
  }


}
