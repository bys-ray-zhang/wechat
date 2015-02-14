package com.wechant.controller;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenTools {

	public static String generateToken(){
		String accessTokeUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx625d6cbd1b3d6390&secret=f56facab1a70fbc1f46df7aaf0f48444";
		HttpGet request = new HttpGet(accessTokeUrl);
		String result = "";
		try {
			HttpResponse response = HttpClients.createDefault().execute(request);
			if(response.getStatusLine().getStatusCode()==200){
				result = EntityUtils.toString(response.getEntity());
			}
			else
			{
				return null;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//{"access_token":"GtMQcV828LYkUxEI1aqDIDI9ANtq9HNyyckm3M22KQUUIyylHkzC10l1D5xucv70BKzpiAdXBcRutMgBxvebwsqPfnV9eeEVavSc_8wCPRQ","expires_in":7200}

		String access_token = null;
		try {
			JSONObject json = new JSONObject(result);
			access_token = json.getString("access_token");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return access_token;
	}
	
}
