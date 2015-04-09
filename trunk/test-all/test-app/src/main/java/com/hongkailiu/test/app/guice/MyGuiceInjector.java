package com.hongkailiu.test.app.guice;

import com.google.inject.AbstractModule;

/**
 * Created by hongkailiu on 2015-04-08.
 */
public class MyGuiceInjector extends AbstractModule {
    @Override
    protected void configure() {
        //bind the service to implementation class
        //bind(MessageService.class).to(EmailService.class);

        //bind MessageService to Facebook Message implementation
        bind(MessageService.class).to(FacebookService.class);
    }
}
