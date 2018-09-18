package com.kteck.actor

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by qiaozhiquan on 2018/9/14.
  * Actor 创建
  */

class HelloActor extends Actor{

  override def receive: Receive = {
    case "你好帅" => println("尽说实话")
    case "丑" => println("滚犊子")
    case "stop" => {
      context.stop(self)
      context.system.terminate()
    }
    case _ => println("不认识你")
  }
}

object HelloActor {

  private val nbFactory = ActorSystem("helloActor")
  private val helloActorRef = nbFactory.actorOf(Props[HelloActor],"HelloActor")

  def main(args: Array[String]): Unit = {

    //给自己发送消息
    helloActorRef ! "你好帅"
    helloActorRef ! "丑"
    helloActorRef ! "stop"
  }

}
