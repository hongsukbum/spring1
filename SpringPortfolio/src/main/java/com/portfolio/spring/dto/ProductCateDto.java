package com.portfolio.spring.dto;

public class ProductCateDto {

	private int pdc_idx;
	private String pdc_name;
	
	
	public ProductCateDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductCateDto(int pdc_idx, String pdc_name) {
		
		this.pdc_idx = pdc_idx;
		this.pdc_name = pdc_name;
		
	}


	public int getPdc_idx() {
		return pdc_idx;
	}


	public void setPdc_idx(int pdc_idx) {
		this.pdc_idx = pdc_idx;
	}


	public String getPdc_name() {
		return pdc_name;
	}


	public void setPdc_name(String pdc_name) {
		this.pdc_name = pdc_name;
	}

}

