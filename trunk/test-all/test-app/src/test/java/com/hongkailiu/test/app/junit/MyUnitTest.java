package com.hongkailiu.test.app.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hongkailiu on 2015-04-12.
 */
public class MyUnitTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConcatenate() throws Exception {
        MyUnit myUnit = new MyUnit();
        String result = myUnit.concatenate("one", "two");
        Assert.assertEquals("onetwo", result);
    }

    @Test
    public void testGetTheStringArray() {
        MyUnit myUnit = new MyUnit();
        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray =  myUnit.getTheStringArray();
        Assert.assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    public void testGetTheBoolean() {
        MyUnit myUnit = new MyUnit();
        Assert.assertTrue(myUnit.getTheBoolean());
        Assert.assertFalse(myUnit.getTheBoolean());
    }

    @Test
    public void testGetTheObject() {
        MyUnit myUnit = new MyUnit();
        Assert.assertNull(myUnit.getTheObject());
        Assert.assertNotNull(myUnit.getTheObject());
    }

    @Test
    public void testGetTheSameObject() {
        MyUnit myUnit = new MyUnit();
        Assert.assertSame(myUnit.getTheSameObject(),
                myUnit.getTheSameObject());
        Assert.assertNotSame(myUnit.getTheSameObject(),
                myUnit.getTheSameObject());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForExceptions1() {
        MyUnit myUnit = new MyUnit();

        myUnit.throwIllegalArgumentException();
    }

    @Test
    public void testForExceptions2() {
        MyUnit myUnit = new MyUnit();

        try {
            myUnit.throwIllegalArgumentException();
            Assert.fail("expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            //ignore, this exception is expected.
        }
    }
}