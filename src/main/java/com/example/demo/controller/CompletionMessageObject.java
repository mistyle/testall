package com.example.demo.controller;

import java.io.Serializable;
/**
 * 竣工消息发送体
 * @author huangs
 *
 */
public class CompletionMessageObject implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String status; //操作状态，中文汉字
	
	private String cardPhone;//接入号
	private String operateType; //操作类型，中文汉字
	private String sendTime; //消息发送时间
	private String desc; //消息描述，或者是错误描述
	
	public CompletionMessageObject(String status, String cardPhone, String operateType, String sendTime, String desc) {
		super();
		this.status = status;
		this.cardPhone = cardPhone;
		this.operateType = operateType;
		this.sendTime = sendTime;
		this.desc = desc;
	}
	
	public CompletionMessageObject() {
		
		
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCardPhone() {
		return cardPhone;
	}
	public void setCardPhone(String cardPhone) {
		this.cardPhone = cardPhone;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
