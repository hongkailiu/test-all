package com.hongkailiu.test.app.mybatis.service;

import com.hongkailiu.test.app.mybatis.entity.Person;
import com.hongkailiu.test.app.mybatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("mybatisPersonService") @Transactional public class PersonService {

    @Autowired private PersonMapper personMapper;

    public List<Person> list() {
        return personMapper.list();
    }

    public void deleteById(int id) {
        personMapper.deleteById(id);
    }

    public void insert(Person person) {
        personMapper.insert(person);
    }
}
