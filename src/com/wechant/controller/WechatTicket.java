package com.wechant.controller;

import java.util.HashMap;
import java.util.Map;

public class WechatTicket {

	public static void main(String[] args) {

		String token = TokenTools.generateToken();
		/*http请求方式: POST
URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
POST数据格式：json
POST数据例子：{"expire_seconds": 1800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}*/
		
		System.out.println("token;  "+token);
		
		String postData = "{\"expire_seconds\": 1800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);
		String post = URLUtil.post(URLUtil.TICKEY_URL, postData, params);
		
		//Gson gson = new Gson();
		System.out.println(post);
		
	}

}
