package com.hongkailiu.test.app.java8.lambda.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by hongkailiu on 2015-04-25.
 */
public class PersonUtil {

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void processPersons(List<Person> roster, Predicate<Person> tester,
        Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
        Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester,
        Function<X, Y> mapper, Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void processElements(List<Person> roster) {
        roster.stream()
            .filter(p -> p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
            .map(p -> p.emailAddress).forEach(email -> System.out.println(email));
    }

    public static int compareByAge(Person a, Person b) {
        if (a.birthday == null || b.birthday == null) {
            throw new IllegalArgumentException("Field birthday is not initialized!");
        }
        return a.birthday.compareTo(b.birthday);
    }
}
