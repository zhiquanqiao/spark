package day03.mytrait

/**
  * Created by qiaozhiquan on 2018/9/14.
  *
  *
  */
object ScalaTraitImpl extends ScalaTrait{

  def hello(name: String): Unit = println(s"hello $name")

  /**
    * 如果要覆写trait 中方法必须要加overide
    * @param name
    */
  override def smile(name: String): Unit = println(s"dingding dui $name 一笑")

  def main(args: Array[String]): Unit = {
    hello("qiaozhiquan")
    smile(" change ")
  }





}
