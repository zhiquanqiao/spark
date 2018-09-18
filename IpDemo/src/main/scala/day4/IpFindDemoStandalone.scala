package day4

import utils.MyUtils

import scala.io.{BufferedSource, Source}

/**
  * Created by qiaozhiquan on 2018/9/18.
  */
object IpFindDemoStandalone {

  /**
    * 读取规则，并放入到内存
    *
    * @param path
    * @return
    */
  def readRule(path: String): Array[(Long, Long, String)] = {
    val bf: BufferedSource = Source.fromFile(path)
    val lines: Iterator[String] = bf.getLines()
    val rules = lines.map(line => {
      val fields = line.split("[|]")
      val startNum = fields(2).toLong
      val endNum = fields(3).toLong
      val province = fields(6)
      (startNum, endNum, province)
    }).toArray
    rules
  }

  /**
    * 二分查找ip段
    *
    * @param lines
    * @param ip
    * @return
    */
  def binarySearch(lines: Array[(Long, Long, String)], ip: Long): Int = {
    var low = 0
    var high = lines.length - 1
    while (low <= high) {
      val middle = (low + high) / 2
      if ((ip >= lines(middle)._1) && (ip <= lines(middle)._2))
        return middle
      if (ip < lines(middle)._1)
        high = middle - 1
      else {
        low = middle + 1
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val memoryRules = readRule("G:\\小牛学堂\\06-Spark安装部署到高级-10天\\spark-04-Spark案例讲解\\课件与代码\\课件与代码\\ip\\ip.txt")
    val ipNum = MyUtils.ip2Long("111.198.38.185")
    println(memoryRules(binarySearch(memoryRules,ipNum))_3)
  }

}
