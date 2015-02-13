package com.wechant.controller;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;

public class Test {

	public static void main(String[] args) throws Exception {
		
		String signature = "cc0fda31fa73203aa19ac482f81e337982caea98";

		String timeStamp = "1423637680";

		String nonce = "857846197";

		String echoStr = "1949016402559696895";
		
		String token = "weixin";
		

		//String token, String encodingAesKey, String appId
		WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token,
				"jWmYm7qr5nMoAUwZRjGtBxmz3KA1tkAj3ykkR6q2B2C", "wxcc6bde21f618cdf8");
		
		wxBizMsgCrypt.verifyUrl(signature, timeStamp, nonce, echoStr);
		
		
	}

}
