package com.hongkailiu.test.testjenkins.listener;

import akka.actor.ActorRef;
import com.hongkailiu.test.testjenkins.MyAkkaPluginApi;
import com.hongkailiu.test.testjenkins.MyMessage;
import hudson.Extension;
import hudson.console.ConsoleNote;
import hudson.model.*;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ehongka on 4/9/15.
 */
@Extension
@Log4j2 public class AkkaBuildListener implements BuildListener {

    @Override
    public void started(List<Cause> list) {
        log.info("AkkaBuildListener: ============started===========");
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getBuildListenerActorRef();
        actorRef.tell(MyMessage.BUILD_STARTED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }

    @Override
    public void finished(Result result) {
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getBuildListenerActorRef();
        actorRef.tell(MyMessage.BUILD_FINISHED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }

    @Override
    public PrintStream getLogger() {
        return null;
    }

    @Override
    public void annotate(ConsoleNote consoleNote) throws IOException {

    }

    @Override
    public void hyperlink(String s, String s1) throws IOException {

    }

    @Override
    public PrintWriter error(String s) {
        return null;
    }

    @Override
    public PrintWriter error(String s, Object... objects) {
        return null;
    }

    @Override
    public PrintWriter fatalError(String s) {
        return null;
    }

    @Override
    public PrintWriter fatalError(String s, Object... objects) {
        return null;
    }
}
