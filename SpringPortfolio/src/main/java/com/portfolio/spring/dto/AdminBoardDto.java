package com.portfolio.spring.dto;

import java.sql.Timestamp;

public class AdminBoardDto {
	private int ab_idx;
	private int ab_qna_idx;
	private String ab_content;
	private Timestamp ab_date;
	
	public AdminBoardDto() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminBoardDto(int ab_qna_idx, String ab_content) {
		this.ab_qna_idx = ab_qna_idx;
		this.ab_content = ab_content;
	}
	
	public int getAb_idx() {
		return ab_idx;
	}
	public void setAb_idx(int ab_idx) {
		this.ab_idx = ab_idx;
	}
	public int getAb_qna_idx() {
		return ab_qna_idx;
	}
	public void setAb_qna_idx(int ab_qna_idx) {
		this.ab_qna_idx = ab_qna_idx;
	}
	public String getAb_content() {
		return ab_content;
	}
	public void setAb_content(String ab_content) {
		this.ab_content = ab_content;
	}
	public Timestamp getAb_date() {
		return ab_date;
	}
	public void setAb_date(Timestamp ab_date) {
		this.ab_date = ab_date;
	}
}
