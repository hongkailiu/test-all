package com.hongkailiu.test.testjenkins;

import akka.actor.ActorRef;
import lombok.Getter;

/**
 * Created by ehongka on 4/9/15.
 */
public class MyAkkaPluginApi {

    private static MyAkkaPluginApi INSTANCE;
    private MyAkkaPluginApi(){
        super();
    }

    public synchronized static MyAkkaPluginApi getInstance(){
        if (INSTANCE==null){
            INSTANCE = new MyAkkaPluginApi();
        }
        return INSTANCE;
    }

    @Getter
    private final ActorRef myAkkaPluginActorRef = MyAkkaPlugin.getMyAkkaPluginActorRef();

    @Getter
    private final ActorRef runListenerActorRef = MyAkkaPlugin.getRunListenerActorRef();

    @Getter
    private final ActorRef saveableListenerActorRef = MyAkkaPlugin.getSaveableListenerActorRef();

    @Getter
    private final ActorRef itemListenerActorRef = MyAkkaPlugin.getItemListenerActorRef();

    @Getter
    private final ActorRef buildListenerActorRef = MyAkkaPlugin.getBuildListenerActorRef();

    @Getter
    private final ActorRef clusterActorRef = MyAkkaPlugin.getClusterActorRef();
}
