package com.hongkailiu.test.app.guice;

import javax.inject.Inject;

/**
 * Created by hongkailiu on 2015-04-08.
 */
public class Consumer {

    private MessageService service;

/*    //constructor based injector
    @Inject
    public Consumer(MessageService svc) {
        this.service = svc;
    }*/


    //setter method injector
    @Inject public void setService(MessageService svc) {
        this.service = svc;
    }

    public boolean sendMessage(String msg, String rec) {
        //some business logic here
        return service.sendMessage(msg, rec);
    }
}
