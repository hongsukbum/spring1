package com.portfolio.spring.dto;

public class VisitorDto {

	private int idx;
	private String uid;
	private String ip;
	private String time;
	
	
	public VisitorDto(String uid, String ip) {

		this.uid = uid;
		this.ip = ip;
		
	}

	

	public String getUid() {
		return uid;
	}




	public void setUid(String uid) {
		this.uid = uid;
	}




	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
