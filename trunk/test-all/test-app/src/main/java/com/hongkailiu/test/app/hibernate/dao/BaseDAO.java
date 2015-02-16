package com.hongkailiu.test.app.hibernate.dao;

import java.util.List;

public interface BaseDAO<T> {
	public void persist(T t);
    public List<T> list();
    public List<T> findByField(String fieldName, Object fieldValue);
    public void delete(T t);
}
