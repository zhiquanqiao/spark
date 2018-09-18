package com.kteck.actor

import akka.actor.{Actor, ActorRef}

/**
  * Created by qiaozhiquan on 2018/9/15.
  */
class LongGeActor(val fg:ActorRef)  extends  Actor{
  override def receive: Receive = {
    case "start" =>{
      println("longlong : I'm ok")
      fg !"啪"
    }
    case "啪啪" => {
      println("你真猛")
      Thread.sleep(1000)
      fg !"啪"
    }
  }
}
