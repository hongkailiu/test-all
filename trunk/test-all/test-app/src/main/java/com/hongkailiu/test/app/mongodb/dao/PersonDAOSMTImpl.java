package com.hongkailiu.test.app.mongodb.dao;

import com.hongkailiu.test.app.mongodb.entity.Person;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * ref.
 * http://spring.io/guides/gs/accessing-data-mongodb/
 *
 * @author Liu
 */
@Repository("personDAOSMTImpl") public class PersonDAOSMTImpl implements PersonDAO {

    private final static String COLLECTION_NAME = "testData";
    @Autowired private MongoTemplate mongoTemplate;

    public Person findById(String id) {
        return mongoTemplate.findById(id, Person.class, COLLECTION_NAME);
    }

    @Override public List<Person> findAll() {
        return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
    }

    @Override public void insert(Person person) {
        mongoTemplate.insert(person, COLLECTION_NAME);
    }

    @SuppressWarnings("unused") @Override public int remove(Person p) {
        WriteResult result = mongoTemplate.remove(p, COLLECTION_NAME);
        return 0;

    }

}
