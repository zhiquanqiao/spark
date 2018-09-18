package cn.kteck.spark

/**
  * Created by qiaozhiquan on 2018/9/17.
  */
object TestSplit {
  def main(args: Array[String]): Unit = {
    val line = "http://bigdata.edu360.cn/laozhang"
    val splits = line.split("/")
    val subject = splits(2).substring(0,splits(2).indexOf("."))
    val teacher = splits(3)
    println(subject + "  " +teacher)
  }
}
