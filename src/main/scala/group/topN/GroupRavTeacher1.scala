package group.topN

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
  * Created by qiaozhiquan on 2018/9/17.
  */
object GroupRavTeacher1 extends App {
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
  //分组排序 按照学科进行分组
  /**
    * 经过分区后，一个分区内可能有多个学科的数据，一个学科就是一个迭代器，一个迭代器里面只有一个学科的数据
    *
    * [学科，该学科对应的数据]
    */
  val grouped:RDD[(String,Iterable[((String,String),Int)])] = reduced.groupBy(_._1._1)
  //将每一个组拿出来进行操作
  //为什么可以调用scala上的sortBy方法，因为一个学科的数据已经在一台机器上的一个集合里面了
  val sorted = grouped.mapValues(_.toList.sortBy(_._2).reverse.take(3))

  println(sorted.collect.toBuffer)
  sc.stop()

}
