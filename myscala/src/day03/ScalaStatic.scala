package day03

/**
  * Created by qiaozhiquan on 2018/9/14.
  * 在scala 中的object 是一个单例对象，在object 中定义的成员变量和成员方法都是静态的
  * 可以通过类名.class
  */
object ScalaStatic {

  val name: String = "张三"
  var age: Int = 18

  def saySomething(name:String) = println(name)
  def apply(food:String) = println(s"米饭$food")
}
