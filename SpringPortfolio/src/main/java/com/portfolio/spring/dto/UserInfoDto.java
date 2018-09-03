package com.portfolio.spring.dto;

import java.sql.Timestamp;

public class UserInfoDto{
	
	private int uidx;
	private String uid;
	private String upw;
	private String unick;
	private String uphone;
	private String uaddr;
	private String ubirth;
	private String ugender;
	private Timestamp ujoinDate;
	private int uenabled;
	private int uauthorityIdx;
	private String ubagId;
	
	
	public UserInfoDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserInfoDto(String uid, String upw, String unick, String uphone, String uaddr, String ubirth, String ugender, Timestamp ujoinDate) {
			
		this.uid = uid;
		this.upw = upw;
		this.unick = unick;
		this.uphone = uphone;
		this.uaddr = uaddr;
		this.ubirth = ubirth;
		this.ugender = ugender;
		this.ujoinDate = ujoinDate;
		
	}
	
	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public int getUidx() {
		return uidx;
	}
	public void setUidx(int uidx) {
		this.uidx = uidx;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUnick() {
		return unick;
	}
	public void setUnick(String unick) {
		this.unick = unick;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUaddr() {
		return uaddr;
	}
	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	public String getUbirth() {
		return ubirth;
	}
	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public Timestamp getUjoinDate() {
		return ujoinDate;
	}
	public void setUjoinDate(Timestamp ujoinDate) {
		this.ujoinDate = ujoinDate;
	}
	public int getUenabled() {
		return uenabled;
	}
	public void setUenabled(int uenabled) {
		this.uenabled = uenabled;
	}
	public int getUauthorityidx() {
		return uauthorityIdx;
	}
	public void setUauthorityidx(int uauthorityIdx) {
		this.uauthorityIdx = uauthorityIdx;
	}
	public String getUbagId() {
		return ubagId;
	}
	public void setUbagId(String ubagId) {
		this.ubagId = ubagId;
	}
	
	public String getPhoneCut(int n) {
		
		String[] result = uphone.split("-");
		
		return result[n];
		
	}
	
	
	
}