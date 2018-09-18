package day05

import java.io.File

import scala.io.Source

/**
  * Created by qiaozhiquan on 2018/9/15.
  */
object ScalaImplicit {
  /**
    * 隐式转换
    *
    * 隐式参数
    * def say(implicit content: String) = println(content)
    *
    * 隐式的类型转换
    *
    * 隐式类 只能应用在object上
    *
    *
    */

  implicit  class FileReader(file:File){
    def read:String = Source.fromFile(file).mkString
  }

  def say(implicit content: String = "明天10 1了") = println(content)

  def add(x: Int)(implicit y: Int) = x + y

  /**
    * 方法的参数如果有多个implicit 只需要使用一个implicit即可
    * 隐式implicit 参数必须放到方法的后面
    *
    * @param a
    * @param b
    * @param c
    * @return
    */
  def addPlus(a: Int)(implicit b: Int, c: Int) = a + b + c

  /**
    * 定义一个隐式方法转化
    * @param double
    * @return
    */
  implicit  def double2Int(double:Double) = double.toInt
  implicit val fdouble2Int = (double:Double) => double.toInt

  def main(args: Array[String]): Unit = {
    say("下午好")
    /**
      * say 方法的参数是隐式参数，编译器在调用的时候，如果没有传递参数的时候，编译器会自动从当前上下文中找一个隐式值（符合参数类类型的隐式值）
      * 定义隐式值的时候不能有歧义
      */
    implicit  val msg = "我最帅"
//    implicit  val msg1 = "我最帅11"
    implicit val content = 1

    say
    println(add(5))
    // age 是一个Int 类型，赋值的时候是一个浮点型，此刻放生了隐式转换，能不能将double变成Int
    val age:Int = 25.99
    println(age)
  }

}
