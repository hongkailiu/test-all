package com.hongkailiu.test.app.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hongkailiu on 2015-04-12.
 */
public class MyUnitMockTest {


    @Test
    public void test() {

        //MyUnitMock myUnitMock = new MyUnitMock();
        //hk: need init the dpdc
        MyUnitMock myUnitMock = new MyUnitMock(new MyDependency());

        myUnitMock.doTheThing("one");

        Assert.assertTrue(myUnitMock.callOneCalled);
        Assert.assertFalse(myUnitMock.callTwoCalled);

        //reset mock before next call
        myUnitMock.callOneCalled = false;

        myUnitMock.doTheThing("two");

        Assert.assertFalse(myUnitMock.callOneCalled);
        Assert.assertTrue(myUnitMock.callTwoCalled);
    }

}