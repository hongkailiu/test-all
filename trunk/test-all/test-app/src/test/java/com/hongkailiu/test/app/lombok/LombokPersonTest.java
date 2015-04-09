package com.hongkailiu.test.app.lombok;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hongkailiu on 2015-04-08.
 */
public class LombokPersonTest {

    @Test
    public void testGetName() throws Exception {
        LombokPerson p = new LombokPerson();
        String name = "3";
        p.setName(name);
        assertEquals(name, p.getName());
    }

    @Test
    public void testWrite2Log() {
        LombokPerson p = new LombokPerson();
        p.write2Log("======here i am=====");
    }
}