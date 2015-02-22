package com.hongkailiu.test.app.mybatis.mapper;

import java.util.List;

import com.hongkailiu.test.app.mybatis.entity.Person;

public interface PersonMapper {
	public List<Person> list();
	public void insert(Person person);
	public void deleteById(int id);
}
