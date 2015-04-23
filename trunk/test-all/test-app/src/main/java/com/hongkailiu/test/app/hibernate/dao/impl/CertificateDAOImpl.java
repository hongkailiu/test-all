package com.hongkailiu.test.app.hibernate.dao.impl;

import com.hongkailiu.test.app.hibernate.dao.CertificateDAO;
import com.hongkailiu.test.app.hibernate.entity.Certificate;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("certificateDaoImpl") public class CertificateDAOImpl extends BaseDAOImpl<Certificate>
    implements CertificateDAO {

    @Override public Certificate findById(int id) {
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery("from Certificate as c where c.id=:id");
        query.setInteger("id", id);
        Certificate result = (Certificate) query.uniqueResult();
        session.close();
        return result;
    }

    @Override public List<Certificate> findByName(String name) {
        return findByField("name", name);
    }

}
