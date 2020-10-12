package com.lqr.testAbstract;
/**
* @author 作者 :lqr
* @version 创建时间：2020年9月28日 下午2:27:27
* 类说明
*/
public class WxPayConfig extends WxPayParentConfig {
	private String appid ;
	private String merchid;
	private String appsecurt;
	private String mkey;
	private String notifyUrl; //后台到账通知地址
	private String refundApplUrl;//退款申请地址
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMerchid() {
		return merchid;
	}
	public void setMerchid(String merchid) {
		this.merchid = merchid;
	}
	public String getAppsecurt() {
		return appsecurt;
	}
	public void setAppsecurt(String appsecurt) {
		this.appsecurt = appsecurt;
	}
	public String getMkey() {
		return mkey;
	}
	public void setMkey(String mkey) {
		this.mkey = mkey;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getRefundApplUrl() {
		return refundApplUrl;
	}
	public void setRefundApplUrl(String refundApplUrl) {
		this.refundApplUrl = refundApplUrl;
	}
	@Override
	public String getParentAppid() {
		return this.getAppid();
	}
	@Override
	public String getParentMerchid() {
		return this.getMerchid();
	}
	@Override
	public String getParentAppsecurt() {
		return this.getAppsecurt();
	}
	@Override
	public String getParentMkey() {
		return this.getMkey();
	}
	@Override
	public String getParentNotifyUrl() {
		return this.getNotifyUrl();
	}
	@Override
	public String getParentRefundApplUrl() {
		return this.getRefundApplUrl();
	}
}
