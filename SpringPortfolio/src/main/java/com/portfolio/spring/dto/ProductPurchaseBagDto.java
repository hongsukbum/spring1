package com.portfolio.spring.dto;

import java.sql.Timestamp;

public class ProductPurchaseBagDto {
	
	private int    pdb_idx;
	private String pdb_uid;
	private int    pdb_pdidx;
	private Timestamp pdb_date;
	private int    pdb_count;
	private int   pdb_state;
	
	private String pd_name;
	private int pd_charge;
	private String ps_name;
	
	
	public ProductPurchaseBagDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductPurchaseBagDto(String pdb_uid, int pdb_pdidx, int pdb_count) {
		
		this.pdb_uid = pdb_uid;
		this.pdb_pdidx = pdb_pdidx;
		this.pdb_count = pdb_count;
		
	}
	
	

	public String getPs_name() {
		return ps_name;
	}

	public void setPs_name(String ps_name) {
		this.ps_name = ps_name;
	}

	public String getPd_name() {
		return pd_name;
	}

	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}

	public int getPd_charge() {
		return pd_charge;
	}

	public void setPd_charge(int pd_charge) {
		this.pd_charge = pd_charge;
	}

	public String getPdb_uid() {
		return pdb_uid;
	}

	public void setPdb_uid(String pdb_uid) {
		this.pdb_uid = pdb_uid;
	}

	public int getPdb_pdidx() {
		return pdb_pdidx;
	}

	public void setPdb_pdidx(int pdb_pdidx) {
		this.pdb_pdidx = pdb_pdidx;
	}

	public int getPdb_idx() {
		return pdb_idx;
	}

	public void setPdb_idx(int pdb_idx) {
		this.pdb_idx = pdb_idx;
	}

	public Timestamp getPdb_date() {
		return pdb_date;
	}

	public void setPdb_date(Timestamp pdb_date) {
		this.pdb_date = pdb_date;
	}

	public int getPdb_count() {
		return pdb_count;
	}

	public void setPdb_count(int pdb_count) {
		this.pdb_count = pdb_count;
	}

	public int getPdb_state() {
		return pdb_state;
	}

	public void setPdb_state(int pdb_state) {
		this.pdb_state = pdb_state;
	}
}
