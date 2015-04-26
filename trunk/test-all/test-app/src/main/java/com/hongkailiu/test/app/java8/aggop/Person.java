package com.hongkailiu.test.app.java8.aggop;

import com.google.gson.Gson;
import com.hongkailiu.test.app.util.MathUtil;
import lombok.extern.log4j.Log4j;

import java.time.LocalDate;

/**
 * ref.
 *
 * https://docs.oracle.com/javase/tutorial/collections/streams/
 *
 * Created by hongkailiu on 2015-04-23.
 */
@Log4j public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    public String name;
    public LocalDate birthday;
    public Sex gender;
    public String emailAddress;
    public int age = -1;

    public int getAge() {
        log.debug("name: " + name + " ==getAge:====");
        if (age==-1){
            int i =MathUtil.random(30);
            log.debug("i: " + i);
            age = i;
        }
        return age;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void printPerson() {
        log.info(toJson());
    }
}
