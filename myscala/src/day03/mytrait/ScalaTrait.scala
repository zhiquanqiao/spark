package day03.mytrait

/**
  * Created by qiaozhiquan on 2018/9/14.
  * 相当于java 中的 interface
  * 在scala 中 trait ，可以定义有实现的方法，也可以定义没有是新啊的方法
  */
trait ScalaTrait {

  def hello(name: String)

  def smile(name: String) = {
    println(s"$name 妩媚一笑")
  }


}
