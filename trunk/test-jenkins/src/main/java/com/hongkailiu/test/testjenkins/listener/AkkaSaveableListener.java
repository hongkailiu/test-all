package com.hongkailiu.test.testjenkins.listener;

import akka.actor.ActorRef;
import com.hongkailiu.test.testjenkins.MyAkkaPluginApi;
import com.hongkailiu.test.testjenkins.MyMessage;
import hudson.Extension;
import hudson.XmlFile;
import hudson.model.Saveable;
import hudson.model.listeners.SaveableListener;
import lombok.extern.log4j.Log4j2;

/**
 * Created by ehongka on 4/9/15.
 */
@Log4j2
@Extension
public class AkkaSaveableListener extends SaveableListener {

    @Override
    public void onChange(final Saveable o, final XmlFile file) {
        log.info("===========fasdfasf=============================");
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getSaveableListenerActorRef();
        actorRef.tell(MyMessage.SAVEABLE_ON_CHANGE, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }
}
