package com.hongkailiu.test.app.java8.lambda.Person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongkailiu on 2015-04-25.
 */
public class PersonUtilTest {

    private List<Person> roster = new ArrayList<>();
    private Person a = new Person();
    private Person b = new Person();

    private final static String ELLE = "elle";
    private final static String HK = "hk";

    @Before public void setup(){
        a = new Person();
        a.name = ELLE;
        a.gender= Person.Sex.FEMALE;
        a.emailAddress = "elle@test.com";
        roster.add(a);

        b = new Person();
        b.name = HK;
        b.gender= Person.Sex.MALE;
        b.emailAddress = "hk@test.com";
        roster.add(b);
    }

    @Test public void testPrintPersons() throws Exception {
        PersonUtil.printPersons(roster, new CheckPersonEligibleForSelectiveService());
    }

    @Test public void testPrintPersonsWithPredicate() throws Exception {
        PersonUtil.printPersonsWithPredicate(roster,
            p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
    }

    @Test public void testProcessPersons() throws Exception {
        PersonUtil.processPersons(roster,
            p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
            p -> p.printPerson());
    }

    @Test public void testProcessPersonsWithFunction() throws Exception {
        PersonUtil.processPersonsWithFunction(roster,
            p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
            p -> p.emailAddress, email -> System.out.println(email));
    }

    @Test public void testProcessElements() throws Exception {
        PersonUtil.processElements(roster,
            p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
            p -> p.emailAddress, email -> System.out.println(email));
    }

    @Test public void testProcessElements2() throws Exception {
        PersonUtil.processElements(roster);
    }

    @Test public void testCompareByAge() throws Exception {
        a.birthday = LocalDate.of(1985, 7, 13);
        b.birthday = LocalDate.of(1980, 4, 10);
        int i = PersonUtil.compareByAge(a,b);
        System.out.println("i: " + i);
        Assert.assertTrue(i > 0);
    }

    /**
     * ref. https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
     * 
     * @throws Exception
     */
    @Test public void testCompareByAge2() throws Exception {
        a.birthday = LocalDate.of(1985, 7, 13);
        b.birthday = LocalDate.of(1980, 4, 10);
        Person[] rosterArray = roster.toArray(new Person[roster.size()]);
        Arrays.sort(rosterArray, PersonUtil::compareByAge);
        //Arrays.sort(rosterArray,  (a, b) -> PersonUtil.compareByAge(a,b));
        //int i = PersonUtil.compareByAge(a,b);
        System.out.println("i: " + rosterArray[0].name);
        Assert.assertTrue(rosterArray[0].name.equals(HK));
    }
}
