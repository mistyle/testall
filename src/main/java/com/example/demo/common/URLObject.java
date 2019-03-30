package com.example.demo.common;

public class URLObject {
	private String infoUrl;
	private String warnUrl;
	
	public URLObject() {
		super();
	}
	public URLObject(String infoUrl, String warnUrl) {
		super();
		this.infoUrl = infoUrl;
		this.warnUrl = warnUrl;
	}
	public String getInfoUrl() {
		return infoUrl;
	}
	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}
	public String getWarnUrl() {
		return warnUrl;
	}
	public void setWarnUrl(String warnUrl) {
		this.warnUrl = warnUrl;
	}
	
	
}
