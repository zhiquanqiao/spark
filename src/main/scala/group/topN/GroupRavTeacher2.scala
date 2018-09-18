package group.topN

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by qiaozhiquan on 2018/9/17.
  */
object GroupRavTeacher2 extends App {
  val conf = new SparkConf().setAppName("FavTeacher").setMaster("local[4]")
  val sc = new SparkContext(conf)
  //指定从哪里读取数据

  val file = "G:\\小牛学堂\\06-Spark安装部署到高级-10天\\spark-03-TopN与WordCount执行过程详解\\课件与代码\\teacher.log"
  val lines = sc.textFile(file)
  //整理数据 学科 老师

  //将想要的数据组合在一起
  val subjectTeacherAndOne: RDD[((String, String), Int)] = lines.map(line => {
    val splits = line.split("/")
    val subject = splits(2).substring(0, splits(2).indexOf("."))
    val teacher = splits(3)
    ((subject, teacher), 1)
  })

  //将学科和老师联合当作key
  val reduced: RDD[((String, String), Int)] = subjectTeacherAndOne.reduceByKey(_ + _)
  val subjects = Array("bigdata","javaee","php")

  /**
    * Spark RDD +磁盘进行排序
    * scala 的集合排序是在内存中进行的，内存可能不够用
    * 可以调用RDD 的sortedBy方法
    * val sorted = grouped.mapValues(_.toList.sortBy(_._2).reverse.take(3)
    */
  //该RDD中的数据只有一个学科的数据
  for(sb <- subjects) {
    val filtered: RDD[((String, String), Int)] = reduced.filter(_._1._1 == sb)
    //现在调用的是rdd 的方法
    val top3 = filtered.sortBy(_._2, false).take(3)
    println(top3.toBuffer)
  }

  sc.stop()

}
