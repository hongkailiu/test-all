package com.hongkailiu.test.testjenkins;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.hongkailiu.test.testjenkins.actor.*;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
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
    private static ActorSystem system;// = ActorSystem.create("PiSystem");
    //private final static ActorSystem system = ActorSystem.create("PiSystem");

    @Getter
    private static ActorRef myAkkaPluginActorRef;// = system.actorOf(Props.create(MyAkkaPluginActor.class), "MyAkkaPluginActorRef");

    @Getter
    private static ActorRef runListenerActorRef;// = system.actorOf(Props.create(RunListenerActor.class), "RunListenerActor");

    @Getter
    private static ActorRef saveableListenerActorRef;// = system.actorOf(Props.create(SaveableListenerActor.class), "SaveableListenerActor");

    @Getter
    private static ActorRef itemListenerActorRef;// = system.actorOf(Props.create(ItemListenerActor.class), "ItemListenerActor");

    @Getter
    private static ActorRef buildListenerActorRef;// = system.actorOf(Props.create(BuildListenerActor.class), "BuildListenerActor");

    @Getter
    private static ActorRef clusterActorRef;

    /**
     * Entry point for the plugin.
     * <p/>
     * Overridden for log messaging.
     */
    @Override public void start() {

        // cluster
        log.info("MyAkkaPlugin: cluster start");
        startup(new String[]{"2552"});

        log.info("MyAkkaPlugin: start");
        runListenerActorRef.tell(MyMessage.START, myAkkaPluginActorRef);
        saveableListenerActorRef.tell(MyMessage.START, myAkkaPluginActorRef);
        itemListenerActorRef.tell(MyMessage.START, myAkkaPluginActorRef);
        buildListenerActorRef.tell(MyMessage.START, myAkkaPluginActorRef);

    }

    public static void startup(String[] ports) {
        for (String port : ports) {
            // Override the configuration of the port
            Config config = ConfigFactory.parseString(
                    "akka.remote.netty.tcp.port=" + port).withFallback(
                    ConfigFactory.load());

            // Create an Akka system
            system = ActorSystem.create("ClusterSystem", config);

            // Create an actor that handles cluster domain events
            clusterActorRef = system.actorOf(Props.create(SimpleClusterListener.class),
                    "clusterListener");

            myAkkaPluginActorRef = system.actorOf(Props.create(MyAkkaPluginActor.class), "MyAkkaPluginActorRef");
            runListenerActorRef = system.actorOf(Props.create(RunListenerActor.class), "RunListenerActor");
            saveableListenerActorRef = system.actorOf(Props.create(SaveableListenerActor.class), "SaveableListenerActor");
            itemListenerActorRef = system.actorOf(Props.create(ItemListenerActor.class), "ItemListenerActor");
            buildListenerActorRef = system.actorOf(Props.create(BuildListenerActor.class), "BuildListenerActor");

        }
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
