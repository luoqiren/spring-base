package com.lqr.testAbstract;
/**
* @author 作者 :lqr
* @version 创建时间：2020年9月28日 下午2:27:41
* 类说明
*/
public class WxMiniPayConfig extends WxPayParentConfig {
	private String miniAppid ;
	private String miniMerchid;
	private String miniAppsecurt;
	private String miniMkey;
	private String miniNotifyUrl; //后台到账通知地址
	private String miniRefundApplUrl;//退款申请地址
	public String getMiniAppid() {
		return miniAppid;
	}
	public void setMiniAppid(String miniAppid) {
		this.miniAppid = miniAppid;
	}
	public String getMiniMerchid() {
		return miniMerchid;
	}
	public void setMiniMerchid(String miniMerchid) {
		this.miniMerchid = miniMerchid;
	}
	public String getMiniAppsecurt() {
		return miniAppsecurt;
	}
	public void setMiniAppsecurt(String miniAppsecurt) {
		this.miniAppsecurt = miniAppsecurt;
	}
	public String getMiniMkey() {
		return miniMkey;
	}
	public void setMiniMkey(String miniMkey) {
		this.miniMkey = miniMkey;
	}
	public String getMiniNotifyUrl() {
		return miniNotifyUrl;
	}
	public void setMiniNotifyUrl(String miniNotifyUrl) {
		this.miniNotifyUrl = miniNotifyUrl;
	}
	public String getMiniRefundApplUrl() {
		return miniRefundApplUrl;
	}
	public void setMiniRefundApplUrl(String miniRefundApplUrl) {
		this.miniRefundApplUrl = miniRefundApplUrl;
	}
	@Override
	public String getParentAppid() {
		return this.getMiniAppid();
	}
	@Override
	public String getParentMerchid() {
		return this.getMiniMerchid();
	}
	@Override
	public String getParentAppsecurt() {
		return this.getMiniAppsecurt();
	}
	@Override
	public String getParentMkey() {
		return this.getMiniMkey();
	}
	@Override
	public String getParentNotifyUrl() {
		return this.getMiniNotifyUrl();
	}
	@Override
	public String getParentRefundApplUrl() {
		return this.getMiniRefundApplUrl();
	}
}
