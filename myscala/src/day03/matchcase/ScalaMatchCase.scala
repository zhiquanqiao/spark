package day03.matchcase

case class SendHeartBeat(id:String,time:Long)
case object CheckTimeOutWorker
/**
  * Created by qiaozhiquan on 2018/9/14.
  */
object ScalaMatchCase {

  def main(args: Array[String]): Unit = {
    //匹配字符串内容
    def contentMatch(str: String) = str match {
      case "hello" => println("hello")
      case "dog" => println("dag")
      case _ => println("匹配不上")
    }

    contentMatch("hello")

    //匹配数据类型

    def typeMatch(tp: Any) = tp match {
      case x: Int => println("int")
      case y: Long => println("long")
      case b: Boolean => println("boolean")
      case _ => println("匹配不上")
    }

    typeMatch(true)
    //匹配Array

    def arrayMatch(arr: Any) = arr match {
      case Array(0) => println("只有一个0元素的数组")
      case Array(0, _) => println("以0开头，拥有2个元素的数组")
      case Array(1, _, 3) => println("以1开头，3结尾，中间任意元素的三个元素的数组")
      case Array(8, _*) => println("以8开头，N个元素的数组")
      case _ => println("没有匹配上")
    }

    arrayMatch(Array(8))
    //匹配List

    println("----------------匹配list----------------")

    def listMatch(list: Any) = list match {
      case 0 :: Nil => println("只有一个0元素的list")
      case 7 :: 9 :: Nil => println("只有7和9元素的list")
      case x :: y :: z :: Nil => println("只有三个元素的list")
      case m :: n if n.length > 0  => println("------------") //拥有head 和 tail的数组
      case _ => println("匹配不上")
    }

    listMatch(List(1))
    listMatch(List(7, 9))
    listMatch(List("x", "y", "z"))
    listMatch(List(666))
    //匹配元组


    println("----------------匹配tuple----------------")
    def tupleMatch(tuple:Any) = tuple match {
      case (0,_) => println("元组的第一个元素为0，第二个元素为任意类型，且只有2个元素")
      case (x,m,k) => println("拥有三个元数的元组")
      case (_,"AK47") => println("第一个是任意类型，第二个值必须是AK47")
    }

    tupleMatch((0,1))
    println("----------------匹配对象----------------")
    //匹配对象
    def objMatch(obj:Any) = obj match{
      case SendHeartBeat(x,y) => println(s"$x   $y")
      case CheckTimeOutWorker => println("---------")
//      case _ => println("没有匹配到对象")
    }

    objMatch(SendHeartBeat("qiaozhiquan",90))
    objMatch(SendHeartBeat("x",900L))
    objMatch(CheckTimeOutWorker)
    objMatch("registerWorker")

  }
}
