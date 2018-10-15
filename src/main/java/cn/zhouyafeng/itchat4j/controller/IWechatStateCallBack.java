package cn.zhouyafeng.itchat4j.controller;

public interface IWechatStateCallBack {
	void onGotWechatUUID();
	
	void onGotLoginQRCodePicSuccessful(String path);
	
	void onGotLoginQRCodePicFailed();
	
	void onLoginTimeout();
	
	void onLoginSuccessful();
	
	void onExit();
	
}
