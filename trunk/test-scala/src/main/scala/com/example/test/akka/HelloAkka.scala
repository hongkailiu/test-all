package com.example.test.akka

import akka.actor.Actor


case object Greet
case class WhoToGreet(who: String)
case class Greeting(message: String)


class Greeter extends Actor {
  var greeting = ""

  def receive = {
    case WhoToGreet(who) => greeting = s"hello, $who"
    case Greet           => sender ! Greeting(greeting) // Send the current greeting back to the sender
  }
}
