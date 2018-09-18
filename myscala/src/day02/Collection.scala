package day02

import scala.collection.mutable._

/**
  * Created by qiaozhiquan on 2018/9/13.
  */
object Collection {

  /**
    * 在scala中，集合分为可变集合和不可变集合，
    * 可变集合：长度可变，内容可变
    * 不可变结合：产犊不可变，内容不可变
    *   Array:长度可变数组ArrayBuffer 长度不可变 Array  但是内容都可变
    * mutable immutable
    *
    * val ab = ArrayBuffer(1,2,4)
    * ab+=(3,5,6)
    *
    * List
    * 100 :: Nil
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
      val ab = ArrayBuffer(1,2,3)
      ab += (4,5,6)

      val list = List(1,2,3)
//      list += (3,4)

      val listBuffer = ListBuffer(2,3,4)
      listBuffer += (5,6,7,8)
      listBuffer(1) = 999


     val mp = Map("xx" -> 1)
  }

}
