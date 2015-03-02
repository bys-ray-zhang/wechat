package com.wechant.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class WechatTicket {

	public static void main(String[] args) {

		String token = TokenTools.generateToken();
		/*http请求方式: POST
URL: https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN
POST数据格式：json
POST数据例子：{"expire_seconds": 1800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}*/
		
		/*System.out.println("token;  "+token);
		
		String postData = "{\"expire_seconds\": 1800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": 123}}}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);
		String post = URLUtil.post(URLUtil.TICKEY_URL, postData, params);
		
		Gson gson = new Gson();
		HashMap fromJson = gson.fromJson(post, HashMap.class);
		
		
		System.out.println(fromJson.get("ticket"));
		
		//访问二维码地址：
		//https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEO8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2NVd015dUxtejRXMkdscktZbUxZAAIE_vrzVAMECAcAAA%3D%3D
		String a = fromJson.get("ticket").toString();
		try {
			System.out.println(URLEncoder.encode(a, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*
		 * 当扫描这二维码时候， 你配置的后台会收到以下信息：
		 * <xml><ToUserName><![CDATA[gh_6052864030e8]]></ToUserName><FromUserName><![CDATA[oHEUCt6nHW2uB97MOLtmJX7Ov0qs]]></FromUserNa
me><CreateTime>1425276088</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[SCAN]]></Event><EventKey><![CDATA[123]]></EventKey><Ticket><![CDATA[gQEO8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2NVd015dUxtejRXMkdscktZbUxZA
AIE_vrzVAMECAcAAA==]]></Ticket></xml>
		 * 
		 * 
		 * 这样，你就可以根据这个ticket来干活了
		 * 
		 * */
		
		String b = "http://120.24.225.227/wechat/wechat.html";
		try {
			System.out.println(URLEncoder.encode(b, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//网页回调：
		//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx625d6cbd1b3d6390&redirect_uri=http%3A%2F%2Fjingyingfood.cn%2Fpublic%2Flogin.html&response_type=code&scope=snsapi_login&state=1ca6b43568fe0d30973805e1e02b9d51#wechat_redirect
		//https://open.weixin.qq.com/connect/qrconnect?appid=wx625d6cbd1b3d6390&redirect_uri=http%3A%2F%2F120.24.225.227%2Fwechat%2Fwechat.html&response_type=code&scope=snsapi_login&state=11111#wechat_redirect
		//https://open.weixin.qq.com/connect/qrconnect?appid=wxbdc5610cc59c1631&redirect_uri=https%3A%2F%2Fpassport.yhd.com%2Fwechat%2Fcallback.do&response_type=code&scope=snsapi_login&state=60eb35f6b356d3e70d3d09af703e2764#wechat_redirect
	}

}
