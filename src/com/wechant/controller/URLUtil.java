package com.wechant.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class URLUtil {
	
	public static String TICKEY_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create";

	public static String post(String url, String postData, Map<String, String> params){
		
		if (params != null && !params.isEmpty())
		{
			StringBuilder sb = new StringBuilder(url);
			sb.append("?");
			for (Map.Entry<String, String> entry : params.entrySet())
			{
				sb.append(entry.getKey());
				sb.append("=");
				try {
					sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				sb.append("&");
			}
			sb.append("1=1");
			url = sb.toString();
		}
		
		HttpPost httpPost = new HttpPost(url);
		try {
			StringEntity stringEntity = new StringEntity(postData, "UTF-8");
			httpPost.setEntity(stringEntity);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String result = "";
			HttpResponse response = HttpClients.createDefault().execute(httpPost);
			if(response.getStatusLine().getStatusCode()==200){
				result = EntityUtils.toString(response.getEntity());
			}
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
