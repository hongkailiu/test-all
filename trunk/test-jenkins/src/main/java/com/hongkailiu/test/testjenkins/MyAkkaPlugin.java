package com.hongkailiu.test.testjenkins;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.hongkailiu.test.testjenkins.actor.*;
import hudson.Plugin;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * Core class for the plugin.
 * <p/>
 * Responsible for initializing, starting up and shutting down plugin
 * and associated resources.
 */
@Log4j2 public class MyAkkaPlugin extends Plugin {

    // Create an Akka system
    private final static ActorSystem system = ActorSystem.create("PiSystem");

    @Getter
    private final static ActorRef myAkkaPluginActorRef = system.actorOf(Props.create(MyAkkaPluginActor.class), "MyAkkaPluginActorRef");

    @Getter
    private final static ActorRef runListenerActorRef = system.actorOf(Props.create(RunListenerActor.class), "RunListenerActor");

    @Getter
    private final static ActorRef saveableListenerActorRef = system.actorOf(Props.create(SaveableListenerActor.class), "SaveableListenerActor");

    @Getter
    private final static ActorRef itemListenerActorRef = system.actorOf(Props.create(ItemListenerActor.class), "ItemListenerActor");

    @Getter
    private final static ActorRef buildListenerActorRef = system.actorOf(Props.create(BuildListenerActor.class), "BuildListenerActor");


    /**
     * Entry point for the plugin.
     * <p/>
     * Overridden for log messaging.
     */
    @Override public void start() {

        log.info("MyAkkaPlugin: start");
        runListenerActorRef.tell(MyMessage.START, myAkkaPluginActorRef);
        saveableListenerActorRef.tell(MyMessage.START, myAkkaPluginActorRef);
        itemListenerActorRef.tell(MyMessage.START, myAkkaPluginActorRef);
        buildListenerActorRef.tell(MyMessage.START, myAkkaPluginActorRef);
    }

    /**
     * Stop the cluster when the plugin stops
     */
    @Override public void stop() throws Exception {
        super.stop();
        runListenerActorRef.tell(MyMessage.DONE, myAkkaPluginActorRef);
        saveableListenerActorRef.tell(MyMessage.DONE, myAkkaPluginActorRef);
        itemListenerActorRef.tell(MyMessage.DONE, myAkkaPluginActorRef);
        buildListenerActorRef.tell(MyMessage.DONE, myAkkaPluginActorRef);
        system.shutdown();
        log.info("MyAkkaPlugin: stop");
    }
}
