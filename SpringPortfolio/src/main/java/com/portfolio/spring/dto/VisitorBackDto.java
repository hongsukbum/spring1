package com.portfolio.spring.dto;

public class VisitorBackDto {

	private int idx;
	private int totalView;
	private int guestView;
	private int loginView;
	private String dateTime;
	
	
	public VisitorBackDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public VisitorBackDto(int totalView, int dayView, int loginView) {
		this.totalView = totalView;
		this.guestView = dayView;
		this.loginView = loginView;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public int getTotalView() {
		return totalView;
	}


	public void setTotalView(int totalView) {
		this.totalView = totalView;
	}


	public int getGuestView() {
		return guestView;
	}


	public void setGuestView(int guestView) {
		this.guestView = guestView;
	}


	public int getLoginView() {
		return loginView;
	}


	public void setLoginView(int loginView) {
		this.loginView = loginView;
	}


	public String getDateTime() {
		return dateTime;
	}


	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getCutDateTime() {
		
		String[] cut = this.dateTime.split(" ");
		return cut[0];
	}
	
}
