package com.hongkailiu.test.testjenkins.actor;

import akka.actor.UntypedActor;
import com.hongkailiu.test.testjenkins.MyMessage;
import lombok.extern.log4j.Log4j2;

/**
 * Created by ehongka on 4/9/15.
 */
@Log4j2
public class SaveableListenerActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
            log.info("SaveableListenerActor get a message: " + message);
            getSender().tell(MyMessage.DONE,getSelf());
    }
}
