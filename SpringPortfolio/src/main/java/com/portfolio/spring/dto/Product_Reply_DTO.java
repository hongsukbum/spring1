package com.portfolio.spring.dto;

public class Product_Reply_DTO {
	private int pdr_idx;
	private String pdr_uid;
	private int pdr_pdIdx;
	private String pdr_content;
	private String pdr_date;
	
	public Product_Reply_DTO(int pdr_idx, String pdr_uid, int pdr_pdIdx, String pdr_content, String pdr_date) {
		this.pdr_idx = pdr_idx;
		this.pdr_uid = pdr_uid;
		this.pdr_pdIdx = pdr_pdIdx;
		this.pdr_content = pdr_content;
		this.pdr_date = pdr_date;
	}
	
	public int getPdr_idx() {
		return pdr_idx;
	}
	public void setPdr_idx(int pdr_idx) {
		this.pdr_idx = pdr_idx;
	}
	public String getPdr_uid() {
		return pdr_uid;
	}
	public void setPdr_uid(String pdr_uid) {
		this.pdr_uid = pdr_uid;
	}
	public int getPdr_pdIdx() {
		return pdr_pdIdx;
	}
	public void setPdr_pdIdx(int pdr_pdIdx) {
		this.pdr_pdIdx = pdr_pdIdx;
	}
	public String getPdr_content() {
		return pdr_content;
	}
	public void setPdr_content(String pdr_content) {
		this.pdr_content = pdr_content;
	}
	public String getPdr_date() {
		return pdr_date;
	}
	public void setPdr_date(String pdr_date) {
		this.pdr_date = pdr_date;
	}
}
