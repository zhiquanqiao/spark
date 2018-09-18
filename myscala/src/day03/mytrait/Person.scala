package day03.mytrait

/**
  * Created by qiaozhiquan on 2018/9/14.
  */
class Student{


}

/**
  * 在scala 中第一个继承抽象类或者是特质只能使用extends  如果想混入多个特质的话，可以在extends 之后使用with关键字
  */
object Person {
  def main(args: Array[String]): Unit = {
    val student = new Student

  }
}
