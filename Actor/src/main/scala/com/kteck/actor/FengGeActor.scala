package com.kteck.actor

import akka.actor.Actor

/**
  * Created by qiaozhiquan on 2018/9/15.
  */
class FengGeActor  extends  Actor{
  override def receive: Receive = {
    case "start" => println("峰峰说：Im ok")
    case "啪" => {
      println("峰峰：那必须的")
      Thread.sleep(1000)
      sender() !"啪啪"
    }
  }
}
