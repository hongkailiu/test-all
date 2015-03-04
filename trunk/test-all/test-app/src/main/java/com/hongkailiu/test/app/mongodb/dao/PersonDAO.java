package com.hongkailiu.test.app.mongodb.dao;

import java.util.List;

import com.hongkailiu.test.app.mongodb.entity.Person;

public interface PersonDAO {
	public void insert(Person person);

	public Person findById(String id);

	public List<Person> findAll();

	public int remove(Person person);
}
