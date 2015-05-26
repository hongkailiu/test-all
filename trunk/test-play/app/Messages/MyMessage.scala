package Messages

import akka.actor.ActorRef
import models.Twitt

/**
 * Created by hongkailiu on 2015-05-25.
 */
class MeMessageOut(out:ActorRef, name:String)
case class MyMessagePlus(out:ActorRef, name:String) extends MeMessageOut(out,name)
case class MyMessageMinus(out:ActorRef, name:String) extends MeMessageOut(out,name)
case class MyMessageNotifyUpdate()
case class MyMessageTwitt(name:String,twitt:Twitt)
