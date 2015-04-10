package com.hongkailiu.test.testjenkins.actor;

import akka.actor.UntypedActor;
import com.hongkailiu.test.testjenkins.MyMessage;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;


@Log4j2

public class ItemListenerActor extends UntypedActor {
    @Getter
    private Object lastMsg;

    @Override
    public void onReceive(Object message) throws Exception {
            log.info("ItemListenerActor get a message: " + message);
            this.lastMsg = message;
            getSender().tell(MyMessage.DONE,getSelf());
    }
}
