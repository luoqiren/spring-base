package com.lqr.util;

public class PmsUserInfosDto {

	private String userAcct; // 用户账户
	private String userPassword; // 用户密码
	private String userRole; // 用户角色,存储格式: R01,R02,R03
	private String updatedDate; // 更新日期
	
	private String startDate;
	private String endDate;

	public PmsUserInfosDto() {
		
	}

	private String getUserAcct() {
		return userAcct;
	}

	private void setUserAcct(String userAcct) {
		this.userAcct = userAcct;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
		
}