package com.kteck.actor

import akka.actor.{ActorSystem, Props}

/**
  * Created by qiaozhiquan on 2018/9/15.
  */
object PingpongApp  extends App{
  private val pingPongActorSystem = ActorSystem("PingPongActorSystem")
  private val ffActorRef = pingPongActorSystem.actorOf(Props[FengGeActor],"ff")
  private val mmActorRef = pingPongActorSystem.actorOf(Props(new LongGeActor(ffActorRef)), "mm")

  ffActorRef ! "start"
  mmActorRef ! "start"

}
