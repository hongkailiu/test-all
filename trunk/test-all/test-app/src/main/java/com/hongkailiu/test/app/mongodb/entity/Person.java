package com.hongkailiu.test.app.mongodb.entity;

import org.springframework.data.annotation.Id;


public class Person {

    @Id private String id;

    private String name;

    private String country;

    public Person(String name, String country) {
        super();
        this.name = name;
        this.country = country;
    }

    public Person() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override public String toString() {
        return String.format("Person[id=%s, name='%s', country='%s']", id, name, country);
    }



}
