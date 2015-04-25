package com.hongkailiu.test.app.akka.actor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;


/**
 * Created by hongkailiu on 2015-04-07.
 */
public class MyUntypedActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override public void onReceive(Object message) throws Exception {
        log.info("message: " + message + " from " + getSender().getClass());
        getSender().tell("received", getSelf());
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MyActorSystem");
        ActorRef ref = system.actorOf(Props.create(MyUntypedActor.class), "myactor");
        ActorRef ref2 = system.actorOf(Props.create(MyUntypedActor2.class), "myactor2");
        ref.tell("ddd", ref2);
    }
}
