package com.portfolio.spring.dto;

public class QnaDto {
	private int qna_idx;
	private String qna_unick;
	private int qna_qnac_idx;
	private int qna_pd_idx;
	private int qna_state;
	private String qna_date;
	private String qna_title;
	private String qna_content;
	
	
	public QnaDto() {
		// TODO Auto-generated constructor stub
	}
	
	public QnaDto(String qna_unick, int qna_qnac_idx, int qna_pd_idx, int qna_state, String qna_title, String qna_content) 
	{
		this.qna_unick = qna_unick;
		this.qna_qnac_idx = qna_qnac_idx;
		this.qna_pd_idx = qna_pd_idx;
		this.qna_state = qna_state;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
	}

	public int getQna_idx() {
		return qna_idx;
	}

	public void setQna_idx(int qna_idx) {
		this.qna_idx = qna_idx;
	}


	public String getQna_unick() {
		return qna_unick;
	}

	public void setQna_unick(String qna_unick) {
		this.qna_unick = qna_unick;
	}

	public int getQna_qnac_idx() {
		return qna_qnac_idx;
	}

	public void setQna_qnac_idx(int qna_qnac_idx) {
		this.qna_qnac_idx = qna_qnac_idx;
	}

	public int getQna_pd_idx() {
		return qna_pd_idx;
	}

	public void setQna_pd_idx(int qna_pd_idx) {
		this.qna_pd_idx = qna_pd_idx;
	}

	public int getQna_state() {
		return qna_state;
	}

	public void setQna_state(int qna_state) {
		this.qna_state = qna_state;
	}

	public String getQna_date() {
		return qna_date;
	}

	public void setQna_date(String qna_date) {
		this.qna_date = qna_date;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
}
