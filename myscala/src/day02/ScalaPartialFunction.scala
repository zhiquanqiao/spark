package day02

/**
  * Created by qiaozhiquan on 2018/9/13.
  */
object ScalaPartialFunction {

  def func(str: String): Int = {
    if (str.equals("a")) 97
    else 0
  }

  /**
    * 偏函数
    *
    * @return
    */
  def func1: PartialFunction[String, Int] = {
    case "a" => 97
    case _ => 0
  }

  def f1: PartialFunction[Int, Int] = {
    case i: Int => i * 10
  }

  def main(args: Array[String]): Unit = {
    println(func1("b"))
    val arr = Array(1, 2, 3)
    println(arr.collect(f1).toBuffer)
    println(arr.map(x => x * 10).toBuffer)
    arr.map({case x:Int => x*10})
  }
}
