package com.lqr.spring.hibernate;

import java.sql.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lqr.spring.hibernate.dao.PmsUserInfosDao;
import com.lqr.spring.hibernate.model.PmsUserInfos;
import com.lqr.spring.hibernate.service.PmsUserInfosService;

public class Test001 {
	@Ignore
	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/hibernate/config/spring-hibernate.xml");
		HibernateTemplate h =(HibernateTemplate) context.getBean("hibernateTemplate"); 
		h.setFetchSize(2);
		PmsUserInfosDao pDao = (PmsUserInfosDao) context.getBean("pmsUserInfosDao");
//		System.out.println(pDao.getMaxNumber());
		
		PmsUserInfos ppp = new PmsUserInfos();
		ppp.setUserAcct("akqq");
		ppp.setUserPassword("akqq");
		ppp.setUserRole("R01");
		ppp.setUpdatedDate(Date.valueOf("2017-08-30"));
		
		pDao.save(ppp);
	}
	@Ignore
	@Test
	public void test2(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/hibernate/config/spring-hibernate.xml");
		PmsUserInfosService pmsUserInfosService = (PmsUserInfosService) context.getBean("pmsUserInfosService");
		System.out.println(pmsUserInfosService.getMaxValue());
	}
	@Ignore
	@Test
	public void test3(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/hibernate/config/spring-hibernate.xml");
		PmsUserInfosService pmsUserInfosService = (PmsUserInfosService) context.getBean("pmsUserInfosService");
//		System.out.println(pDao.getMaxNumber());
		
		PmsUserInfos ppp = new PmsUserInfos();
		ppp.setUserAcct("akqq");
		ppp.setUserPassword("akqq");
		ppp.setUserRole("R01");
		ppp.setUpdatedDate(Date.valueOf("2017-08-30"));
		
		pmsUserInfosService.add(ppp);
	}

	@Test
	public void test4Delete(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/hibernate/config/spring-hibernate.xml");
		PmsUserInfosService pmsUserInfosService = (PmsUserInfosService) context.getBean("pmsUserInfosService");
//		System.out.println(pDao.getMaxNumber());
		
		PmsUserInfos ppp = new PmsUserInfos();
		ppp.setUserAcct("akqq");
		ppp.setUserPassword("akqq");
		ppp.setUserRole("R01");
		ppp.setUpdatedDate(Date.valueOf("2017-08-30"));
		
		pmsUserInfosService.delete(ppp);
	}
}
