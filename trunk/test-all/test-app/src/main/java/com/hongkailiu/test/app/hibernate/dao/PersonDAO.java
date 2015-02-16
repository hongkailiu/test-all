package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

import com.hongkailiu.test.app.hibernate.entity.Person;

public interface PersonDAO extends BaseDAO<Person> {
    public Person findById(int id);
    public List<Person> findByName(String name);
    public List<Person> findByName2(String name);
}
