package customsort

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by qiaozhiquan on 2018/9/18.
  */
object CustomSort1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CustomSort1").setMaster("local[4]")
    val sc = new SparkContext(conf)

    //排序规则 首先按照颜值的从高到底排序 （降序），如果颜值相等，再按照年龄的从低到高排序（升序）
    val users = Array("laoduan 30 99", "laozhao 29 9999", "laozhang 38 99", "laoyang 90 99")

    //将Driver端数据并行化变成RDD
    val lines: RDD[String] = sc.parallelize(users, 3)
    //切分整理数据
    val userRDD: RDD[User] = lines.map(line => {
      val fields = line.split(" ")
      val name = fields(0)
      val age = fields(1).toInt
      val fv = fields(2).toInt
      new User(name, age, fv)
    })

    //不满足要求
    //tpRDD.sortBy(tp => tp._3,false)
    //将RDD里面装的User类型进行排序
    val sorted = userRDD.sortBy(u => u)
    val r = sorted.collect()
    println(r.toBuffer)
    sc.stop()
  }
}

case class User(val name: String, val age: Int, val fv: Int) extends Ordered[User] {

  override def compare(that: User): Int = {
    if (this.fv == that.fv) {
      this.age - that.age
    } else {
      that.fv - this.fv
    }
  }

}
