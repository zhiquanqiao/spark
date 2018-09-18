package day02

/**
  * Created by qiaozhiquan on 2018/9/13.
  */
object BigData {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 4, 5, 6, 6, 7)
    arr.map(x => x * 10)
    arr.map(_ * 10)

    /**
      * flattten 扁平化操作
      */
    val arr1  = Array("Hello woorld ccc ddd dddd ssss","ddd dddd ssss aaa abbb vv ggg ghhhhh")
    println(arr1.map(_.split(" ")).flatten.toBuffer)
    println(arr1.flatMap(_.split(" ")).toBuffer)
    val r2:Array[Array[String]] = arr1.map(_.split(" "))

    /**
      * flatMap  = map flatten
      */

    println(arr1.flatMap(_.split(" ")).groupBy( x => x).mapValues(x=>x.length).toList.sortBy(x => - x._2).toBuffer)

  }
}
