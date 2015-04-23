package com.hongkailiu.test.app.mongodb.dao;

import com.hongkailiu.test.app.mongodb.entity.Person;

import java.util.List;

public interface PersonDAO {
    public void insert(Person person);

    public Person findById(String id);

    public List<Person> findAll();

    public int remove(Person person);
}
