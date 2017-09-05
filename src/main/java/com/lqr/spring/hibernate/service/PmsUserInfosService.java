package com.lqr.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lqr.spring.hibernate.dao.PmsUserInfosDao;
import com.lqr.spring.hibernate.model.PmsUserInfos;

@Transactional
@Service
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
	
	
}
