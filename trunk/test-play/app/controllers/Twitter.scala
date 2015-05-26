package controllers

import Messages.{MyMessageMinus, MyMessagePlus}
import akka.actor.{Actor, ActorRef, Props}
import helper.TwitterHelper
import play.Logger
import play.api.Play.current
import play.api.mvc.{Action, Controller, WebSocket}

object Twitter extends Controller {
  //val system = ActorSystem.create("testPlay")

  //http://localhost:9000/persons/all
  def index = Action {
    Ok(views.html.twitter("twitter is here"))
  }

  def show(hashTag: String) = Action {
    Ok(views.html.twitter(hashTag))
  }

  def twitterWebSocket = WebSocket.acceptWithActor[String, String] { request => out => {
    Logger.info("request.uri: " + request.uri)
    //var name = "dummy"
    val o: Option[String] = request.getQueryString("name")

    if (o != None && o.isDefined) {
      val name: String = o.get
      MyWebSocketActor.props(out, name)
    } else {
      Logger.info("abnormal uri: " + request.uri)
      //Props.empty
      throw new IllegalArgumentException("abnormal uri: " + request.uri)
    }
    //val name:String = request.getQueryString("name").getOrElse(0)
    //val uri:String = request.uri
    //val name:String = uri.substring(uri.lastIndexOf('/')+1)
    //Logger.info("name: " + name)
    //val name = request.
    //MyWebSocketActor.props(out, TwitterHelper.dwts)
    //MyWebSocketActor.props(out, "dwts")
  }


  }

}

object MyWebSocketActor {
  def props(out: ActorRef, name: String) = Props(new MyWebSocketActor(out, name))
}

class MyWebSocketActor(out: ActorRef, name: String) extends Actor {
  override def preStart() = {
    Logger.info("MyWebSocketActor: Connected!")
    TwitterHelper.myActorRef ! MyMessagePlus(out, name)
  }

  //private[this] var (channel) = Concurrent.broadcast[String]
  override def receive = {
    case msg: String => {
      Logger.info("MyWebSocketActor receive: " + msg)
      out ! msg
    }

  }

  override def postStop() = {
    Logger.info("MyWebSocketActor: Disconnected!")
    TwitterHelper.myActorRef ! MyMessageMinus(out, name)
  }

}
