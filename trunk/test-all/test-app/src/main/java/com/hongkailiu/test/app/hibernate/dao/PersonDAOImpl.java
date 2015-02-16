package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hongkailiu.test.app.hibernate.entity.Person;

public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = (List<Person>) session.createQuery("from Person").list();
		session.close();
		return personList;
	}

	@Override
	public Person findById(int id) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Person as p where p.id=:id");
		query.setInteger("id", id);
		Person person = (Person) query.uniqueResult();
		session.close();
		return person;
	}

	@Override
	public void delete(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByName(String name) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Person as p where p.name=:name");
		query.setString("name", name);
		List<Person> personList = query.list();
		session.close();
		return personList;
	}

}
