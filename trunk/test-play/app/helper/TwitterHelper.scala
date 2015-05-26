package helper

import java.util.List
import java.util.concurrent.{ExecutorService, Executors}

import Messages.{MyMessageTwitt, MeMessageOut, MyMessageMinus, MyMessagePlus}
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
  val dwts = "dwts"
  val myHandler = new MyHandler

  val myActorRef = play.libs.Akka.system.actorOf(Props[MyActor], name = "myactor")

  def start() = {
    pool.submit(new TwitterService(dwts, 3, 10 * 1000, myHandler))
  }

  val dwtsSet:Set[Twitt] = Set()

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
    //println(twitt)
    TwitterHelper.myActorRef ! MyMessageTwitt(TwitterHelper.dwts, twitt)
  }
}


class MyActor extends Actor {

  //var outs: Set[ActorRef] = Set()
  var map:Map[MeMessageOut, Set[Twitt]] = Map()

  //private[this] var (channel) = Concurrent.broadcast[String]
  override def receive = {

    case MyMessagePlus(out,name) => {
      Logger.info(s"MyActor: plug $out $name.")
      //outs = outs + out
      map = map + (MyMessagePlus(out,name) -> Set())
    }
    case MyMessageMinus(out,name)  => {
      Logger.info(s"MyActor: minus $out $name.")
      //outs = outs - out
      map = map - MyMessagePlus(out,name)
    }
    case MyMessageTwitt(name, twitt)  => {
      Logger.info(s"MyActor: MyMessageTwitt $name $twitt.")
      //outs = outs - out
      Logger.info("map: " + map)
      val notifyMap = map.filter{
        case (MyMessagePlus(out,name), s:Set[Twitt]) => {
          //Logger.info("MyMessagePlus(out,name): "+MyMessagePlus(out,name))
          //Logger.info("TwitterHelper.dwts.equals(name): " +  TwitterHelper.dwts.equals(name))
          TwitterHelper.dwts.equals(name)
        }
      }
      Logger.info("notifyMap: " + notifyMap)
      notifyMap.foreach { case (MyMessagePlus(out,name), s:Set[Twitt]) => {
        if (!s.contains(twitt)) {
          Logger.info("send to : " + out + " with: " + twitt)
          out ! twitt.toString
          map = map + (MyMessagePlus(out,name) -> (s+twitt))
        }
      } }

    }
    case _ => Logger.info("MyActor receive: unknown message")
    //case msg: String => {
    //  Logger.info("MyWebSocketActor receive: " + msg)
    //  out ! msg
    //}

  }
  override def preStart() = {
    Logger.info("MyActor: preStart!")
    //outs = Set()
     map = Map()
  }

  override def postStop() = {
    Logger.info("MyActor: postStop!")
    /*if (outs!=null) {
      outs = null
    }*/
    if (map!=null){
      map=null
    }
  }

}
