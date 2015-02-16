package com.hongkailiu.test.app.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import com.hongkailiu.test.app.hibernate.dao.PersonDAO;
import com.hongkailiu.test.app.hibernate.entity.Person;

@Repository("personDaoImpl")
public class PersonDAOImpl extends BaseDAOImpl<Person> implements PersonDAO {

	@Override
	public Person findById(int id) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Person as p where p.id=:id");
		query.setInteger("id", id);
		Person result = (Person) query.uniqueResult();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByName2(String name) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Person as p where p.name=:name");
		query.setString("name", name);
		List<Person> result = query.list();
		session.close();
		return result;
	}
	
	@Override
	public List<Person> findByName(String name) {
		return super.findByField("name", name);
	}

}
