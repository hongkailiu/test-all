package com.hongkailiu.test.app.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hongkailiu on 2015-04-08.
 */
public class ConsumerTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendMessage() throws Exception {
        Injector injector = Guice.createInjector(new MyGuiceInjector());
        Consumer consumer = injector.getInstance(Consumer.class);
        Assert.assertEquals(true, consumer.sendMessage("Hi Pankaj", "pankaj@abc.com"));
    }
}