package com.hongkailiu.test.app.hibernate.dao;

import com.hongkailiu.test.app.hibernate.entity.Certificate;

import java.util.List;

public interface CertificateDAO extends BaseDAO<Certificate> {
    public Certificate findById(int id);

    public List<Certificate> findByName(String name);
}
