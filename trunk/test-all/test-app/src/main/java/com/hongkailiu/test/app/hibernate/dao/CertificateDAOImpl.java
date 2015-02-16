package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hongkailiu.test.app.hibernate.entity.Certificate;

public class CertificateDAOImpl implements CertificateDAO {

	
	private SessionFactory sessionFactory;
	 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    @Override
    public void save(Certificate c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(c);
        tx.commit();
        session.close();
    }
    
    @Override
    public void delete(Certificate c) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Certificate> list() {
        Session session = this.sessionFactory.openSession();
        List<Certificate> certificateList = session.createQuery("from Certificate").list();
        session.close();
        return certificateList;
    }

	@Override
	public Certificate findById(int id) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Certificate as c where c.id=:id");
		query.setInteger("id", id);
		Certificate certificate = (Certificate) query.uniqueResult();
		session.close();
		return certificate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Certificate> findByName(String name) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Certificate as c where c.name=:name");
		query.setString("name", name);
		List<Certificate> certificateList = query.list();
		session.close();
		return certificateList;
	}

}
