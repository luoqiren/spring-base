package com.lqr.testAbstract;
/**
* @author 作者 :lqr
* @version 创建时间：2020年10月10日 下午2:01:25
* 类说明
*/
public class TestGetValue {

	public static void main(String[] args) {
		WxPayConfig wxPayConfig = new WxPayConfig();
		wxPayConfig.setAppid("appid 11111111");
		wxPayConfig.setAppsecurt("appsecurt 122222222222222");
		wxPayConfig.setMerchid("merchid 13333333333333333");
		wxPayConfig.setMkey("mkey 144444444444444");
		wxPayConfig.setNotifyUrl("notifyurl 1555555");
		wxPayConfig.setRefundApplUrl("refundurl 16666666666666");
		outputInfo(wxPayConfig);
		
		WxMiniPayConfig wxMiniPayConfig = new WxMiniPayConfig();
		wxMiniPayConfig.setMiniAppid("Miniappid 11111111");
		wxMiniPayConfig.setMiniAppsecurt("Miniappsecurt 122222222222222");
		wxMiniPayConfig.setMiniMerchid("Minimerchid 13333333333333333");
		wxMiniPayConfig.setMiniMkey("Minimkey 144444444444444");
		wxMiniPayConfig.setMiniNotifyUrl("Mininotifyurl 1555555");
		wxMiniPayConfig.setMiniRefundApplUrl("Minirefundurl 16666666666666");
		outputInfo(wxMiniPayConfig);
		
	}

	public static void outputInfo(WxPayParentConfig wxPayParentConfig) {
		System.out.println(wxPayParentConfig.getParentAppid());
		System.out.println(wxPayParentConfig.getParentAppsecurt());
		System.out.println(wxPayParentConfig.getParentMerchid());
		System.out.println(wxPayParentConfig.getParentMkey());
		System.out.println(wxPayParentConfig.getParentNotifyUrl());
		System.out.println(wxPayParentConfig.getParentRefundApplUrl());
	}
}
