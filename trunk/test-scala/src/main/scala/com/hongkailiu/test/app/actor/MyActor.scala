package com.hongkailiu.test.app.actor

import akka.actor.{ActorLogging, Props, ActorSystem, Actor}
import akka.actor.Actor.Receive
import akka.event.Logging

/**
 * Created by hongkailiu on 2015-04-13.
 */
class MyActor extends Actor with ActorLogging {
  //override def receive: Receive = ???

  var name = self.path.name

  //  def getName() : String = {
  //    self.path.name
  //  }

  @throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    super.preStart()
  }

  def handle(msg: String): Unit = {
    log.info(name + ": handle msg: " + msg)
  }

  override def receive: Receive = {
    case msg: String => {
      log.info(name + ": received msg")
      handle(msg)
    }
    case msg => {
      unhandled(msg)
      log.info(name + ": received unknown message")
    }
  }


}

object MyActorMain extends App {
  println("aaa")
  val system = ActorSystem("mySystem")
  val myActor1 = system.actorOf(Props[MyActor], "myActor1")
  val myActor2 = system.actorOf(Props[MyActor], "myActor2")
  myActor1.tell("my test msg", myActor2)
  myActor1.tell(3, myActor2)
  println("bbb")
}


