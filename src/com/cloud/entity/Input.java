package com.cloud.entity;

public class Input {

	private String baseUrl = "";
	
	private int pollFrequency = 0;
	
	private int noUsers = 0;
	
	private String method = "";
	
	private String path = "";
	
	private String textarea = "";
	
	private int noCalls = 0;

	private int first = 0;
	
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getNoCalls() {
		return noCalls;
	}

	public void setNoCalls(int noCalls) {
		this.noCalls = noCalls;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public int getPollFrequency() {
		return pollFrequency;
	}

	public void setPollFrequency(int pollFrequency) {
		this.pollFrequency = pollFrequency;
	}

	public int getNoUsers() {
		return noUsers;
	}

	public void setNoUsers(int noUsers) {
		this.noUsers = noUsers;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}
	
	@Override
	public String toString() {
		String s = "baseUrl" + baseUrl + "pollFrequency" 
	+ pollFrequency + "noUsers " +noUsers + "method " + method + "path" + path;
	
		return s.toString();
	}
	
}
