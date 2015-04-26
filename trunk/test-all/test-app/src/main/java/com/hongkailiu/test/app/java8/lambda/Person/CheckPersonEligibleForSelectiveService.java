package com.hongkailiu.test.app.java8.lambda.Person;

/**
 * Created by hongkailiu on 2015-04-25.
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson {

    @Override public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}
