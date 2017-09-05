package com.lqr.spring.springcache;

import java.sql.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.lqr.spring.springcache.dao.PmsUserInfosDao;
import com.lqr.spring.springcache.model.PmsUserInfos;
import com.lqr.spring.springcache.service.PmsUserInfosService;

public class Test001 {
	@Ignore
	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/springcache/config/spring-hibernate.xml");
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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/springcache/config/spring-hibernate.xml");
		PmsUserInfosService pmsUserInfosService = (PmsUserInfosService) context.getBean("pmsUserInfosService");
		System.out.println(pmsUserInfosService.getMaxValue());
	}
	@Ignore
	@Test
	public void test3(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/springcache/config/spring-hibernate.xml");
		PmsUserInfosService pmsUserInfosService = (PmsUserInfosService) context.getBean("pmsUserInfosService");
//		System.out.println(pDao.getMaxNumber());
		
		PmsUserInfos ppp = new PmsUserInfos();
		ppp.setUserAcct("akqq");
		ppp.setUserPassword("akqq");
		ppp.setUserRole("R01");
		ppp.setUpdatedDate(Date.valueOf("2017-08-30"));
		
		pmsUserInfosService.add(ppp);
	}
	@Ignore
	@Test
	public void test4Delete(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/springcache/config/spring-hibernate.xml");
		PmsUserInfosService pmsUserInfosService = (PmsUserInfosService) context.getBean("pmsUserInfosService");
//		System.out.println(pDao.getMaxNumber());
		
		PmsUserInfos ppp = new PmsUserInfos();
		ppp.setUserAcct("akqq");
		ppp.setUserPassword("akqq");
		ppp.setUserRole("R01");
		ppp.setUpdatedDate(Date.valueOf("2017-08-30"));
		pmsUserInfosService.delete(ppp);
		ConcurrentHashMap c;
	}
	
	
	@Test
	public void test5Cache(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/lqr/spring/springcache/config/spring-hibernate.xml");
		PmsUserInfosService pmsUserInfosService = (PmsUserInfosService) context.getBean("pmsUserInfosServiceBean");
		String userAcct = "admin";
		//第一次， 查询数据库
		System.out.println("Query first:");
		pmsUserInfosService.getPmsUserInfos(userAcct);
		//第二次， 查询缓存， 在缓存中直接返回
		System.out.println("Second Query:");
		pmsUserInfosService.getPmsUserInfos(userAcct);
		
		//删除缓存
		System.out.println("Clear cache First:");
		pmsUserInfosService.removePmsUserCache(userAcct);
		
		//第三次 
		System.out.println("Third Query:");
		pmsUserInfosService.getPmsUserInfos(userAcct);
	}
}
