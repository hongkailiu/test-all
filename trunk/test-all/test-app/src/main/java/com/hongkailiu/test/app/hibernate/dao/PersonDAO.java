package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

import com.hongkailiu.test.app.hibernate.entity.Person;

public interface PersonDAO {
	public void save(Person p);
    public List<Person> list();
    public Person findById(int id);
}
