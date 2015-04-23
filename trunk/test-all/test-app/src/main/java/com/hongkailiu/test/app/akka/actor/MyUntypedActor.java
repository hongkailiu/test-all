package com.hongkailiu.test.app.akka.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;


/**
 * Created by hongkailiu on 2015-04-07.
 */
public class MyUntypedActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override public void onReceive(Object message) throws Exception {
        log.info("message: " + message);
    }
}
