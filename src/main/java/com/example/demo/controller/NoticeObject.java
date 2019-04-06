package com.example.demo.controller;

import java.io.Serializable;

public class NoticeObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String serviceRequestId; //服务请求ID
	private int type;   //类型，竣工通知，还是流量池通知 ，值参考MessageNoticeType.java
	private Object message;  //json格式，转对象的时候，如果是竣工通知，按CompletionMessageObject对象去转
	
	public String getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public NoticeObject() {

	}
	
	public NoticeObject(String serviceRequestId,int type, Object message) {
		super();
		this.serviceRequestId = serviceRequestId;
		this.type = type;
		this.message = message;
	}

	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

//	@Override
//	public String toString() {
//		String sContent = "type="+this.type+"&message="+this.message;
//		return sContent;
//	}
}
