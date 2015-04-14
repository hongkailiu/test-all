package com.hongkailiu.test.app.actor

import akka.actor.{Props, ActorSystem}
import com.typesafe.config.ConfigFactory

/**
 * Created by hongkailiu on 2015-04-13.
 */
object SimpleClusterApp {
  def main(args: Array[String]): Unit = {
    if (args.isEmpty)
      //startup(Seq("2551", "2552", "0"))
      startup(Seq("2552"))
    else
      startup(args)
  }

  def startup(ports: Seq[String]): Unit = {
    ports foreach { port =>
      // Override the configuration of the port
      val config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port).
        withFallback(ConfigFactory.load())

      // Create an Akka system
      val system = ActorSystem("ClusterSystem", config)
      // Create an actor that handles cluster domain events
      system.actorOf(Props[SimpleClusterListener], name = "clusterListener")
    }
  }
}
