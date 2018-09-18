package day4

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import utils.MyUtils

/**
  * Created by qiaozhiquan on 2018/9/18.
  */
object IpLocation1 {

  def main(args: Array[String]): Unit = {
    val a = "G:\\小牛学堂\\06-Spark安装部署到高级-10天\\spark-04-Spark案例讲解\\课件与代码\\课件与代码\\ip\\ip.txt"
    val b = "G:\\小牛学堂\\06-Spark安装部署到高级-10天\\spark-04-Spark案例讲解\\课件与代码\\课件与代码\\ip\\access.log"
    val conf = new SparkConf().setAppName("IpLocation1").setMaster("local[4]")
    val sc = new SparkContext(conf)
    //在driver 端获取到全部的ip规则数据(全部的ip规则数据就在某台数机器上)
    val rules: Array[(Long, Long, String)] = MyUtils.readRules(a)
    //将Driver 端的数据广播到executor
    //调用sc上的广播方法

    //引用还存咋Driver端
    val broadcastRef: Broadcast[Array[(Long, Long, String)]] = sc.broadcast(rules)
    //创建RDD读取访问日志
    val accessLines: RDD[String] = sc.textFile(b)

    //这个函数在driver端定义的
    val func = (line: String) => {
      val fileds = line.split("[|]")
      val ip = fileds(1)
      val ipLong = MyUtils.ip2Long(ip)
      //进行二分法查找,通过Driver端的引用获取到executor端的变量
      // (该函数中的代码在Executor中执行的)
      //通过广播变量的引用就可以拿到当前Executor中的规则
      val ruleInExecutor: Array[(Long, Long, String)] = broadcastRef.value
      //查找
      val index = MyUtils.binarySearch(ruleInExecutor, ipLong)
      var province = "未知"
      if (index != -1) {
        province = ruleInExecutor(index)._3
      }
      (province, 1)
    }

    //整理数据
    val provinceOne: RDD[(String, Int)] = accessLines.map(func)
    //聚合
    val reduced:RDD[(String,Int)] = provinceOne.reduceByKey(_ + _)
    //将结果打印
    val r = reduced.collect()
    println(r.toBuffer)
    sc.stop();
  }
}
