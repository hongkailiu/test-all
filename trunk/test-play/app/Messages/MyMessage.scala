package Messages

import akka.actor.ActorRef

/**
 * Created by hongkailiu on 2015-05-25.
 */
case class MyMessagePlus(out:ActorRef, name:String)
case class MyMessageMinus(out:ActorRef, name:String)
case class MyMessageNotifyUpdate()
