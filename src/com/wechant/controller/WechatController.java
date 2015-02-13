package com.wechant.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.process.WechatProcess;

@Controller
public class WechatController {
	
	@RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
	public void test(HttpServletRequest request, HttpServletResponse response, InputStream requestBodyIn /*Reader reader*/){
		
		 	String signature = request.getParameter("signature");// 微信加密签名 
	        String timestamp = request.getParameter("timestamp");// 时间戳 
	        String nonce = request.getParameter("nonce");// 随机数 
	        String echostr = request.getParameter("echostr");//
	        String token = "weixin";// 
	        
	        System.out.print("signature:  "+signature);
	        System.out.print("timestamp:  "+timestamp);
	        System.out.print("nonce:  "+nonce);
	        System.out.print("echostr:  "+echostr);
	        
	       
	        
	        //验证 
	        //if (Tools.checkSignature(_token, signature, timestamp, nonce)) { 
	        	if (echostr != null)
	        	{	
	        		try {
						response.getWriter().write(echostr);
					} catch (IOException e) {
						e.printStackTrace();
					}
	        	}
				else
				{
					/** 读取接收到的xml消息 */
					StringBuffer sb = new StringBuffer();
					InputStream is = requestBodyIn;
					
					
					try {
						InputStreamReader isr = new InputStreamReader(is, "UTF-8");
						BufferedReader br = new BufferedReader(isr);
						String s = "";
						while ((s = br.readLine()) != null) {
							sb.append(s);
						}
						String xml = sb.toString();	//次即为接收到微信端发送过来的xml数据
						
						System.out.println("xml:  "+xml);
						String result = "";
						result = new WechatProcess().processWechatMag(xml);
						
						try {
							OutputStream os = response.getOutputStream();
							os.write(result.getBytes("UTF-8"));
							
							System.out.println("result:  "+result);
							
							os.flush();
							os.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
					
	       // } 
		
	}
	
	
	public static void main(String[] args){
		
		String xml = "<xml><ToUserName><![CDATA[gh_6052864030e8]]></ToUserName><FromUserName><![CDATA[oHEUCt6nHW2uB97MOLtmJX7Ov0qs]]>"
				+ "</FromUserName><CreateTime>1423808287</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[Hello]]></Content><MsgId>6115210028641995417</MsgId></xml>";
		 String processWechatMag = new WechatProcess().processWechatMag(xml);
		
	}
	
}
