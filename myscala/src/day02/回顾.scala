package day02

/**
  * Created by qiaozhiquan on 2018/9/13.
  */
object 回顾 {
  /**
    * 可变参数
    * deg method(str :String,a:Any)
    *
    * 默认值函数
    * def method1（a:Int = 6，x:String = "a"）
    *
    * method1(x="X",a=8)  参数顺序可变
    *
    * 高阶函数，参数是函数或者是返回值是函数
    *
    * def method3(f:Int =>Int,c:Int) = f(c)
    *
    * 柯里化函数
    * def method4 (x:Int)(y:Int)
    * method4(0),(4)
    *
    * 偏函数 ：PartialFunction[参数类型，函数返回值类型]
    * def method5 :PartialFunction[String,Int]   参数类型只有一个
    *   case x: String => 90
    *
    * 数组的定义
    *   Array 长度不可变，内容可变
    *     map flatten flatmap foreach
    *   map
    *     10 => function =>100
    *   arr.map(????)
    *   flatten 扁平化操作
    *     将
    *
    *
    *
    */

}
