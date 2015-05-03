package com.hongkailiu.test.app.bit;

import org.junit.Test;

/**
 * Created by hongkailiu on 2015-05-02.
 */
public class BitUtilTest {

    @Test public void test() throws Exception {
        byte b = -2;
        System.out.println("high: " + BitUtil.getHigh4bits(b));
        System.out.println("low: " + BitUtil.getLow4bits(b));
    }
}
