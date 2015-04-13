package com.hongkailiu.test.app.junit;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hongkailiu on 2015-04-12.
 */
public class MyIOUnitTest {
    @Test
    public void testRead() throws IOException {
        MyIOUnit unit = new MyIOUnit();

        //byte[] data = "123,456,789,123,456,789".getBytes();
        //hk: need one more comma
        byte[] data = "123,456,789,123,456,789,".getBytes();

        InputStream input = new ByteArrayInputStream(data);

        unit.read(input);

        Assert.assertEquals("123", unit.tokens.get(0));
        Assert.assertEquals("456", unit.tokens.get(1));
        Assert.assertEquals("789", unit.tokens.get(2));
        Assert.assertEquals("123", unit.tokens.get(3));
        Assert.assertEquals("456", unit.tokens.get(4));
        Assert.assertEquals("789", unit.tokens.get(5));
    }
    @Test
    public void testWrite() throws IOException {
        MyIOUnit unit = new MyIOUnit();

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        unit.tokens.add("one");
        unit.tokens.add("two");
        unit.tokens.add("three");

        unit.write(output);

        String string = new String(output.toByteArray());
        Assert.assertEquals("one,two,three", string);
    }
}