package com.lqr.spring.springcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqr.spring.springcache.dao.PmsUserInfosDao;
import com.lqr.spring.springcache.model.PmsUserInfos;

@Transactional
@Service(value="pmsUserInfosServiceBean")
public class PmsUserInfosService {
	
	@Autowired
	@Qualifier(value="pmsUserInfosDao")
	private PmsUserInfosDao pDao;
	
	public void add(PmsUserInfos pmsUserInfos){
		this.pDao.save(pmsUserInfos);
	}
	
	public void delete(PmsUserInfos pmsUserInfos){
		this.pDao.delete(pmsUserInfos);
	}
	
	public long getMaxValue(){
		
		return this.pDao.getCounter();
//		return this.pDao.getMaxNumber();
	}
	
	@Cacheable(cacheNames="users")
	public PmsUserInfos getPmsUserInfos(String userAcct){
		System.out.println("Real query user:" + userAcct);
		return this.pDao.get(userAcct);
	}
	
	@CacheEvict(cacheNames="users")
	public void removePmsUserCache(String userAcct){
		System.out.println("remove user from caches.");
	}
	
	
}
