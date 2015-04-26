package com.hongkailiu.test.app.java8.lambda.Person;

import org.junit.Test;

/**
 * Created by hongkailiu on 2015-04-25.
 */
public class PersonTest {

    @Test public void testPrintPerson() throws Exception {
        Person p = new Person();
        p.name = "elle";
        p.printPerson();
    }
}
