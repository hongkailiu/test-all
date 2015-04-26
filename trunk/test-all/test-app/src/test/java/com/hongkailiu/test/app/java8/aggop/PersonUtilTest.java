package com.hongkailiu.test.app.java8.aggop;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by hongkailiu on 2015-04-25.
 */
public class PersonUtilTest {

    private List<Person> roster = new ArrayList<>();

    @Before public void setup() {
        Person p;
        p = new Person();
        p.name = "elle";
        p.gender = Person.Sex.FEMALE;
        p.emailAddress = "elle@test.com";
        roster.add(p);

        p = new Person();
        p.name = "hk";
        p.gender = Person.Sex.MALE;
        p.emailAddress = "hk@test.com";
        roster.add(p);
    }

    @Test public void testPrintPersons() throws Exception {

        Person.Sex g = Person.Sex.FEMALE;

        PersonUtil.printPersons(roster, g);

        roster.clear();
        PersonUtil.printPersons(roster, g);

        roster = null;
        try {
            PersonUtil.printPersons(roster, g);
            Assert.fail("NullPointerException should occur!");
        } catch (NullPointerException e) {

        }
    }

    @Test public void testGetAverageAge() throws Exception {
        Person.Sex g = Person.Sex.FEMALE;
        double d = PersonUtil.getAverageAge(roster, g);
        Assert.assertTrue(d > -1);


        roster.clear();
        try {
            d = PersonUtil.getAverageAge(roster, g);
        } catch (NoSuchElementException e) {

        }


    }

}
