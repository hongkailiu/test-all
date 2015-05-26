package helper

import java.util.List
import java.util.concurrent.{ExecutorService, Executors}

import Messages.{MyMessageMinus, MyMessagePlus}
import models.Twitt
import play.Logger
import twitter4j.{Status, QueryResult}
import akka.actor._

import scala.collection.JavaConversions._

/**
 * Created by ehongka on 5/25/15.
 */
object TwitterHelper {

  val pool: ExecutorService = Executors.newFixedThreadPool(1)
  val dwts = "#dwts"
  val myHandler = new MyHandler

  val myActorRef = play.libs.Akka.system.actorOf(Props[MyActor], name = "myactor")

  def start() = {

    pool.submit(new TwitterService(dwts, 3, 10 * 1000, myHandler))
  }



  def plus(actorRef: ActorRef) = {

  }

  def minus(actorRef: ActorRef) = {

  }
}


class MyHandler() extends ResultHandler {
  override def handle(queryResult: QueryResult): Unit = {

    val list: List[Status] = queryResult.getTweets
    if (list!=null){
      for(x <- list) handleStatus(x)
    }

  }

  def handleStatus(status:Status): Unit = {
    /*println("=====a=======")
    println(status.getCreatedAt)
    println(status.getId)
    println(status.getText)
    println("=====b=======")*/
    val twitt = new Twitt(status.getCreatedAt.toString, java.lang.Long.toString(status.getId), status.getText)
    println(twitt)

  }
}


class MyActor extends Actor {

  var outs: Set[ActorRef] = Set()

  //private[this] var (channel) = Concurrent.broadcast[String]
  override def receive = {

    case MyMessagePlus(out,name) => {
      Logger.info(s"MyActor: plug $out $name.")
      outs = outs + out
    }
    case MyMessageMinus(out,name)  => {
      Logger.info(s"MyActor: minus $out $name.")
      outs = outs - out
    }
    case _ => Logger.info("Someone said goodbye to me.")
    //case msg: String => {
    //  Logger.info("MyWebSocketActor receive: " + msg)
    //  out ! msg
    //}

  }
  override def preStart() = {
    Logger.info("MyActor: preStart!")
    outs = Set()
  }

  override def postStop() = {
    Logger.info("MyActor: postStop!")
    if (outs!=null) {
      outs = null
    }
  }

}
