package controllers

import Messages.{MyMessageMinus, MyMessagePlus}
import akka.actor.{Actor, Props, ActorRef}
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
    val uri:String = request.uri
    val name:String = uri.substring(uri.lastIndexOf('/')+1)
    Logger.info("name: " + name)
    //MyWebSocketActor.props(out, TwitterHelper.dwts)
    MyWebSocketActor.props(out,name)
  }

  }

}

object MyWebSocketActor {
  def props(out: ActorRef, name:String) = Props(new MyWebSocketActor(out,name))
}

class MyWebSocketActor(out: ActorRef, name:String) extends Actor {
  override def preStart() = {
    Logger.info("MyWebSocketActor: Connected!")
    TwitterHelper.myActorRef ! MyMessagePlus(out,name)
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
    TwitterHelper.myActorRef ! MyMessageMinus(out,name)
  }

}
