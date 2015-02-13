package com.wechant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class MenuTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"button\": [");
		sb.append("{");
		sb.append("\"type\": \"click\","); 
		sb.append("\"name\": \"今日歌曲\","); 
		sb.append("\"key\": \"V1001_TODAY_MUSIC\"");
		sb.append("},"); 
		sb.append("{");
		sb.append("\"type\": \"click\","); 
		sb.append("\"name\": \"歌手简介\","); 
		sb.append("\"key\": \"V1001_TODAY_SINGER\"");
		sb.append("},"); 
		sb.append("{");
		sb.append("\"name\": \"菜单\","); 
		sb.append("\"sub_button\": [");
		sb.append("{");
		sb.append("\"type\": \"view\","); 
		sb.append("\"name\": \"搜索\","); 
		sb.append("\"url\": \"http://www.soso.com/\"");
		sb.append("},"); 
		sb.append("{");
		sb.append("\"type\": \"view\","); 
		sb.append("\"name\": \"视频\","); 
		sb.append("\"url\": \"http://v.qq.com/\"");
		sb.append("},"); 
		sb.append("{");
		sb.append("\"type\": \"click\","); 
		sb.append("\"name\": \"赞一下我们\","); 
		sb.append("\"key\": \"V1001_GOOD\"");
		sb.append("}");
		sb.append("]");
		sb.append("}");
		sb.append("]");
		sb.append("}");
		
		
		String menuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
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
				return;
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
		
		
		Menu menu  = new Menu();
		List<MenuItem> menuitems = new ArrayList<MenuItem>();
		
		MenuItem menuItem = new MenuItem();
		menuItem.setType("click");
		menuItem.setName("今日歌曲");
		menuItem.setKey("V1001_TODAY_MUSIC");
		menuitems.add(menuItem);
		
		MenuItem menuItem0 = new MenuItem();
		menuItem0.setName("菜单");
		menuitems.add(menuItem0);
		
		List<MenuItem> submenuitems = new ArrayList<MenuItem>();
		menuItem = new MenuItem();
		menuItem.setType("view");
		menuItem.setName("163");
		menuItem.setUrl("http://www.163.com");
		submenuitems.add(menuItem);
		menuItem = new MenuItem();
		menuItem.setType("view");
		menuItem.setName("QQ");
		menuItem.setUrl("http://www.qq.com");
		submenuitems.add(menuItem);
		menuItem0.setSub_button(submenuitems);
		
		menu.setButton(menuitems);
		
		
		
		
		HttpPost httpPost = new HttpPost(menuUrl+access_token);
		JSONObject postData = new JSONObject();
		
		
		Gson gson = new Gson();
		String json = gson.toJson(menu);
		System.out.println(json);
		
		try {
			StringEntity stringEntity = new StringEntity(json, "UTF-8");
			httpPost.setEntity(stringEntity);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		try {
			HttpResponse response = HttpClients.createDefault().execute(httpPost);
			if(response.getStatusLine().getStatusCode()==200){
				result = EntityUtils.toString(response.getEntity());
				System.out.println("result:  "+result);
			}
			else
			{
				return;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
