package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

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
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Certificate> list() {
        Session session = this.sessionFactory.openSession();
        List<Certificate> certificateList = session.createQuery("from Certificate").list();
        session.close();
        return certificateList;
    }

}
