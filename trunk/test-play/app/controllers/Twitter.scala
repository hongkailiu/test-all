package controllers

import akka.actor.{Actor, Props, ActorRef}
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

  def twitterWebSocket = WebSocket.acceptWithActor[String, String] { request => out =>
    MyWebSocketActor.props(out)
  }

  object MyWebSocketActor {
    def props(out: ActorRef) = Props(new MyWebSocketActor(out))
  }

  class MyWebSocketActor(out: ActorRef) extends Actor {
    override def preStart() = {
      Logger.info("Connected!")
    }

    //private[this] var (channel) = Concurrent.broadcast[String]
    override def receive = {
      case msg: String => {
        Logger.info("MyWebSocketActor receive: " + msg)
        out ! msg
      }

    }
    override def postStop() = {
      Logger.info("Disconnected!")
    }

  }

}
