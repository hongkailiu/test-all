package com.hongkailiu.test.app.guice;

import javax.inject.Singleton;

/**
 * Created by hongkailiu on 2015-04-08.
 */
@Singleton public class EmailService implements MessageService {
    @Override public boolean sendMessage(String msg, String receipient) {
        //some fancy code to send email
        System.out.println("Email Message sent to " + receipient + " with message=" + msg);
        return true;
    }
}
