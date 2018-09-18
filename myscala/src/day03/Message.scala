package day03

/**
  * Created by qiaozhiquan on 2018/9/14.
  *
  * 样例类  case class 类名（属性...）  必须是驼峰式命名的
  * 默认实现了Serializable
  *
  */
case class Message(sender:String,messageContent:String) {

}

/**
  * 样例对象
  * 最重要的功能也是进行模式匹配
  */


case object CheckHeardBeat


object TestCaseClass{
  def main(args: Array[String]): Unit = {
    val message = new Message("杨幂","晚上吃饭")
    message.sender
    message.messageContent
  }

}