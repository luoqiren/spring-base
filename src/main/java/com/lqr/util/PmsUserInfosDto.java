package com.lqr.util;

public class PmsUserInfosDto {

	private String userAcct; // �û��˻�
	private String userPassword; // �û�����
	private String userRole; // �û���ɫ,�洢��ʽ: R01,R02,R03
	private String updatedDate; // ��������
	
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