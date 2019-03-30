package com.example.demo.test.http;

import com.example.demo.common.ApiHttpCommUtils;
import com.example.demo.common.URLObject;
import com.google.gson.Gson;
/**
 * 发送http请求，返回json格式数据（请求地址要支持返回json）
 * @author lenovo
 *
 */
public class HttpTest {
	
	
	public static void main(String[] args) {
		String[] header = { "Content-Type","token" };
		String[] values = { "application/json","aaaa" };

		try {	
			URLObject urlObject = new URLObject();
			urlObject.setInfoUrl("http://www.baidu.com2");
		urlObject.setWarnUrl("http://www.baidu.com2");	
		String  content = new Gson().toJson(urlObject); //body体
		// 查申通快递单号
			System.out.println(ApiHttpCommUtils.sendHttpRequest("http://www.kuaidi100.com/query?type=shentong&postid=7704224152150","POST", header, values,null));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
