package com.lqr.spring.hibernate.dao;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BasicDao<T> {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private Class<T> entityClass;

	public BasicDao() {
		Type genType = getClass().getGenericSuperclass();
		Type [] params =( (ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public T get(Serializable id){
		return this.hibernateTemplate.get(entityClass, id);
	}
	
	public void save(T entity){
		this.hibernateTemplate.save(entity);
	}
	
	public void update(T entity){
		this.hibernateTemplate.update(entity);
	}
	
	public void delete(T entity){
		this.hibernateTemplate.delete(entity);
	}
	
}
