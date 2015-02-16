package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

import com.hongkailiu.test.app.hibernate.entity.Certificate;

public interface CertificateDAO extends BaseDAO<Certificate> {
    public Certificate findById(int id);
    public List<Certificate> findByName(String name);
}
