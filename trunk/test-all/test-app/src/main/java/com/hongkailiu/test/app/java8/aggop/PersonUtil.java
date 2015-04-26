package com.hongkailiu.test.app.java8.aggop;

import lombok.extern.log4j.Log4j;

import java.util.List;

/**
 * Created by hongkailiu on 2015-04-25.
 */
@Log4j public class PersonUtil {

    public static void printPersons(List<Person> roster, Person.Sex g) {
        roster.stream().filter(e -> e.gender == g).
            forEach(e -> log.info(e.toJson()));
    }


    public static double getAverageAge(List<Person> roster, Person.Sex g) {
        double average = roster
            .stream()
            .filter(p -> p.gender == Person.Sex.MALE)
            .mapToInt(Person::getAge)
            .average()
            .getAsDouble();
        return average;
    }
}
