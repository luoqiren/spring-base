package com.lqr.spring.hibernate.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PMS_USER_INFOS")
public class PmsUserInfos implements Serializable{

	private String userAcct; // 
	private String userPassword; // 
	private String userRole; // 
	private Date updatedDate; //  
	
	private Date startDate;
	private Date endDate;

	public PmsUserInfos() {
		
	}
	
	@Id
	@Column(name="USER_ACCT", length=60)
	public String getUserAcct() {
		return userAcct;
	}

	public void setUserAcct(String userAcct) {
		this.userAcct = userAcct;
	}

	@Column(name="USER_PASSWORD", length=60)
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name="USER_ROLE", length=100)
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Column(name="UPDATEDDATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}