package group.topN

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partition, Partitioner, SparkConf, SparkContext}

import scala.collection.mutable

/**
  * Created by qiaozhiquan on 2018/9/17.
  */
object GroupRavTeacher3 extends App {
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

  /**
    * 如何将相同学科的数据suffle中同一个分区中
    * 自定义分区器
    *
    * RDD有多个分区，一个分区有一个Task
    * 分区器是一个类，决定上游的到那个分区中
    */

  //将学科和老师联合当作key
  val reduced: RDD[((String, String), Int)] = subjectTeacherAndOne.reduceByKey(_ + _)

  //计算有多少学科
  val subjects =  reduced.map(_._1._1).distinct().collect()

  /**
    * 按照指定的分区规则进行分区
    */
  val sb = new  SubjectPartition(subjects)
  val partitioned:RDD[((String,String),Int)] = reduced.partitionBy(sb)

  //如何一次拿到一个分区
  val sorted = partitioned.mapPartitions(it => {
    it.toList.sortBy(_._2).reverse.take(3).iterator  //将迭代器转换成List 然后排序，在转换成迭代器返回
  })  //可以操作一个分区中的数据了
  println(sorted.collect().toBuffer)
  sc.stop()

}

class SubjectPartition(subjects:Array[String]) extends Partitioner{

  //用于初始化规则的map
  val rules = new mutable.HashMap[String,Int]()

  for (sb <-  0 until subjects.length ){
    rules.put(subjects(sb),sb)
  }

  //返回分区的数量，也就是下一个RDD有多少分区
  override def numPartitions: Int = subjects.length

  //根据传入的key,计算分区编号
  //key是一个元组
  override def getPartition(key: Any): Int = {
    val subject = key.asInstanceOf[(String,String)]._1
    rules.get(subject).get
  }
}