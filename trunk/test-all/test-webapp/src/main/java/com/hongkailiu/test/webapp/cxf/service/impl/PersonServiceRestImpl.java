package com.hongkailiu.test.webapp.cxf.service.impl;

import com.hongkailiu.test.webapp.cxf.service.PersonServiceRest;
import com.hongkailiu.test.webapp.cxf.vo.Person;
import org.apache.log4j.Logger;

import java.util.Date;

//@Repository("personServiceRestImpl")
public class PersonServiceRestImpl implements PersonServiceRest {

    static Logger logger = Logger.getLogger(PersonServiceRestImpl.class);

    @Override public Person create(Person person) {
        logger.debug("create");
        return person;
    }

    @Override public Person read(String id) {
        logger.debug("read");
        Person p = new Person();
        p.setUsername("a");
        p.setPassword("b");
        p.setBirthdate(new Date());
        return p;
    }

    @Override public void update(String uuid, Person person) {
        // TODO Auto-generated method stub

    }

    @Override public void delete(String uuid) {
        // TODO Auto-generated method stub

    }

}
