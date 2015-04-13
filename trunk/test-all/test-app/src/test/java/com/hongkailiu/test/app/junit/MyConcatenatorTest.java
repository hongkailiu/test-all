package com.hongkailiu.test.app.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hongkailiu on 2015-04-12.
 */
public class MyConcatenatorTest {

    @Test
    public void testConcatenate() throws Exception {
        String concatenated =
                MyConcatenator.concatenate(
                        "one", "two", "three", "four");

        Assert.assertEquals("one,two,three,four", concatenated);
    }
}