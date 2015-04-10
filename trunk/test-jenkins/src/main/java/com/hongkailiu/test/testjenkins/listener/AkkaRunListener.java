package com.hongkailiu.test.testjenkins.listener;

import akka.actor.ActorRef;
import com.hongkailiu.test.testjenkins.MyAkkaPluginApi;
import com.hongkailiu.test.testjenkins.MyMessage;
import hudson.Extension;
import hudson.model.Run;
import hudson.model.TaskListener;
import hudson.model.listeners.RunListener;
import lombok.extern.log4j.Log4j2;

/**
 * Created by ehongka on 4/9/15.
 */
@Extension @Log4j2
public class AkkaRunListener<R extends Run> extends RunListener<R> {

    @Override
    public void onCompleted(R run, TaskListener listener) {
        super.onCompleted(run, listener);
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getRunListenerActorRef();
        actorRef.tell(MyMessage.RUN_ON_COMPLETED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }

    @Override
    public void onStarted(R run, TaskListener listener) {
        super.onStarted(run, listener);
        log.info("AkkaRunListener: ===============onStarted==================");
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getRunListenerActorRef();
        actorRef.tell(MyMessage.RUN_ON_STARTED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }

    @Override
    public void onDeleted(R run) {
        super.onDeleted(run);
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getRunListenerActorRef();
        actorRef.tell(MyMessage.RUN_ON_DELETED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }
}
