package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

import com.hongkailiu.test.app.hibernate.entity.Certificate;

public interface CertificateDAO {
	public void save(Certificate c);
    public List<Certificate> list();
}
