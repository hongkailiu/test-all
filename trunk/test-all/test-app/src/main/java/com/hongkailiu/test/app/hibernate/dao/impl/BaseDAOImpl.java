package com.hongkailiu.test.app.hibernate.dao.impl;

import com.hongkailiu.test.app.hibernate.dao.BaseDAO;
import com.hongkailiu.test.app.util.ReflectionUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.util.List;

public class BaseDAOImpl<T> implements BaseDAO<T> {

    private Class<T> entityClass;
    @Resource(name = "hibernate3AnnotatedSessionFactory") private SessionFactory sessionFactory;


    public BaseDAOImpl() {
        this.entityClass = ReflectionUtil.getClassGenricType(getClass());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override public void persist(T t) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(t);
        tx.commit();
        session.close();
    }

    @SuppressWarnings({"unchecked", "rawtypes"}) @Override public List<T> list() {
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(entityClass);
        List list = criteria.list();
        session.close();
        return list;
    }

    @SuppressWarnings({"rawtypes", "unchecked"}) @Override
    public List<T> findByField(String propertyName, Object value) {
        Session session = this.sessionFactory.openSession();
        Criteria criteria = session.createCriteria(entityClass);
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List list = criteria.add(Restrictions.eq(propertyName, value)).list();
        session.close();
        return list;
    }

    @Override public void delete(T t) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(t);
        tx.commit();
        session.close();
    }

}
