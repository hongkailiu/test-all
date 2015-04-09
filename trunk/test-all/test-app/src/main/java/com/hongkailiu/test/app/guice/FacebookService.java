package com.hongkailiu.test.app.guice;

import javax.inject.Singleton;

/**
 * Created by hongkailiu on 2015-04-08.
 */
@Singleton
public class FacebookService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String receipient) {
        //some complex code to send Facebook message
        System.out.println("Message sent to Facebook user "+receipient+" with message="+msg);
        return true;
    }
}
