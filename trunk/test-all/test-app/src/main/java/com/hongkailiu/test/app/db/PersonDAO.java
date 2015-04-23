package com.hongkailiu.test.app.db;

import java.util.List;

public interface PersonDAO {
    public int save(Person person);

    public Person findById(int id);

    public List<Person> list();

    public int deleteById(int id);
}
