package com.lqr.spring.springcache.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.lqr.spring.springcache.model.PmsUserInfos;

@Repository
public class PmsUserInfosDao extends BasicDao<PmsUserInfos> {

	public void add(PmsUserInfos pmsUserInfos){
		this.getHibernateTemplate().save(pmsUserInfos);
	}
	
	public void delete(PmsUserInfos pmsUserInfos){
		this.getHibernateTemplate().delete(pmsUserInfos);
	}
	
	public void update(PmsUserInfos pmsUserInfos){
		this.getHibernateTemplate().update(pmsUserInfos);
	}
	
	public PmsUserInfos getPmsUserInfos (String userAcct){
		return this.getHibernateTemplate().get(PmsUserInfos.class, userAcct);
	}
	
	@SuppressWarnings("unchecked")
	public List<PmsUserInfos> getList(String userAcct){
		return (List<PmsUserInfos>) this.getHibernateTemplate().find("from PmsUserInfos p where 1=1 and p.userAcct like ?",
					userAcct+"%");
	}
	
	public int getCounter(){
		return this.getHibernateTemplate().find("from PmsUserInfos p where 1=1 ").size();
	}
	//回调函数
	public Long getMaxNumber(){
		return this.getHibernateTemplate().execute(
				new HibernateCallback<Long>() {
					@Override
					public Long doInHibernate(Session session) throws HibernateException {
						int obj = session.createQuery("select count(p.userAcct) from PmsUserInfos p").list().size();
						System.out.println(obj);
						return Long.valueOf(obj);
					}
					
				} 
			);
	}
	
}
