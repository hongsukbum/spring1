package com.portfolio.spring.dto;

public class QnaCateDto {
	
	private int qnac_idx;
	private String qnac_name;
	
	public QnaCateDto() {
		
	}
	
	public QnaCateDto(int qnac_idx, String qnac_name) {
		this.qnac_idx = qnac_idx;
		this.qnac_name = qnac_name;
	}
	
	public int getQnac_idx() {
		return qnac_idx;
	}
	public void setQnac_idx(int qnac_idx) {
		this.qnac_idx = qnac_idx;
	}
	public String getQnac_name() {
		return qnac_name;
	}
	public void setQnac_name(String qnac_name) {
		this.qnac_name = qnac_name;
	}
}
